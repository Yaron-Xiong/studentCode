package com.yaronxiong.sql.lean;

import java.sql.*;

public class NetworkStudent {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://10.17.1.75:3306/testSpringBoot?useSSL=false&useServerPrepStmts=true&cachePrepStmts=true&connectTimeout=500&socketTimeout=170000";
        String user = "oss";
        String password = "oss";
        String interval = "100";
        String refArticleId = "1628";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "select sleep(10) `LinkId` from GW_LinkManager where RefArticleId= ?";
            while (true) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, refArticleId);
                ResultSet resultSet = statement.executeQuery();
                resultSet.close();
                statement.close();

                PreparedStatement statement1 = connection.prepareStatement(sql);
                statement1.setString(1, refArticleId);
                ResultSet resultSet1 = statement1.executeQuery();
                while (resultSet1.next()) {
                    System.out.println("fine");
                }
                resultSet1.close();
                statement1.close();
                Thread.sleep(Long.parseLong(interval));
                break;
            }
        }
    }
}
