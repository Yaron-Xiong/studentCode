package com.yaronxiong.io.dns;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 测试结果
 * Dns默认过期时间为30S
 * 如果需要修改，可以使用-Dsun.net.inetaddr.ttl=10  进行修改
 *
 * 实验有趣现象如下
 * 在运行期 ，改了java.security 中的 networkaddress.cache.ttl  无法生效
 * 在运行前 ，改了java.security 中的 networkaddress.cache.ttl  无法生效
 * 使用-Dsun.net.inetaddr.ttl=10 正常生效
 */
public class DnsExpiredTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException {
        System.out.println(System.getSecurityManager());
        System.out.println(System.getenv("networkaddress.cache.ttl"));
        Class.forName("com.mysql.jdbc.Driver");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int current = 0;
        DriverManager.setLoginTimeout(12);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://short-url-db.com:3306/short_url?useSSL=false", "oss", "oss");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT `Current` from IDGenInfo");
            while (resultSet.next()) {
                current = resultSet.getInt("Current");
                System.out.println(format.format(new Date()) + "=" + current);
            }
        }
        for (int i = 0; true; i++) {
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://short-url-db.com:3306/short_url?useSSL=false", "oss", "oss");
                 Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT `Current` from IDGenInfo");
                int nextCurrent = 0;
                while (resultSet.next()) {
                    nextCurrent = resultSet.getInt("Current");
                    //System.out.println(format.format(new Date()) + "=" + resultSet.getInt("Current"));
                }
                if (nextCurrent != current) {
                    System.out.println(format.format(new Date()) + "=" + nextCurrent);
                }
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
