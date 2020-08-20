package com.union.code;

import java.sql.*;

/**
 * description
 *
 * @author Mr.Cheng
 * @date 2020/8/20
 */
public class JDBCUtils {

    public static Connection connection() {
        Connection connection = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "123456");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }


    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
