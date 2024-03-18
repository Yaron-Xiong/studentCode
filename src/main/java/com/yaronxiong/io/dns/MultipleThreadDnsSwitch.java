package com.yaronxiong.io.dns;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.pool.HikariPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MultipleThreadDnsSwitch {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HikariConfig hikariConfig = new HikariConfig();
        String connStr = String.format("jdbc:mysql://%s/%s?useSsl=false", "short-url-db.com:3306", "short_url");
        hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
        hikariConfig.setJdbcUrl(connStr);
        hikariConfig.setUsername("oss");
        hikariConfig.setPassword("oss");

        hikariConfig.setAutoCommit(true);
        hikariConfig.setConnectionTimeout(12000);
        // 由于当前线上设置小于默认值，会有warn日志，所以小于该值就直接不设置该参数了
        hikariConfig.setIdleTimeout(600000);
        hikariConfig.setConnectionTestQuery("SELECT 1;");
        hikariConfig.setMinimumIdle(0);
        hikariConfig.setMaximumPoolSize(3);
        hikariConfig.setInitializationFailTimeout(-1);
        //开启Mbean监控
        hikariConfig.setRegisterMbeans(true);
        //poolName不能有:
        //因为多分区有相同dnName、只读库等存在，需要加上ip区分
        hikariConfig.setPoolName("HikariConnectionPool-" + "short-url");
        HikariPool hikariPool = new HikariPool(hikariConfig);
        for (int i = 0; i < 5; i++) {
            int finalI = i + 1;
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    try {
                        try (Connection connection = hikariPool.getConnection();
                             Statement statement = connection.createStatement()) {
                            ResultSet resultSet = statement.executeQuery("SELECT `Current` from IDGenInfo");
                            while (resultSet.next()) {
                                int current = resultSet.getInt("Current");
                                System.out.println(format.format(new Date()) + "=" + current);
                            }
                            TimeUnit.SECONDS.sleep(finalI * 2L);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        continue;
                    }
                }
            });
            thread.start();
        }
        TimeUnit.SECONDS.sleep(1000);
        hikariPool.shutdown();
    }

}
