package com.union.code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * description
 *
 * @author Mr.Cheng
 * @date 2020/8/20
 */
public class Client {
    public static void main(String[] args) throws SQLException {
        /*test()01*/
        //test01();


        /*模板优化后的方法*/
        moduleTest();

        iTest();

        //employee


    }

    private static void iTest() throws SQLException {
        String sql = "select * from user where id in (?,?,?,?)";
        Object[] objects = new Object[]{1, 2, 1225, 7};
        List<User> userList = JDBCTemplate.query(sql, new UserIRowImpl(), objects);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    private static void moduleTest() throws SQLException {
        String sql = "select * from user where id in (?,?,?,?)";
        Object[] objects = new Object[]{1, 2, 1225, 7};
        List<User> userList = JDBCTemplate.query(sql, objects);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    private static void test01() throws SQLException {
        Connection connection = JDBCUtils.connection();
        String sql = "select * from user where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, 2);
        ResultSet resultSet = ps.executeQuery();
        User user = null;
        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt(1));
            user.setUsername(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setNickname(resultSet.getString(4));
            user.setQuestion(resultSet.getString(5));
            user.setAnswer(resultSet.getString(6));
            user.setGmtCreate(resultSet.getDate(7));
            user.setGmtModified(resultSet.getDate(8));
        }
        System.out.println(user.toString());
    }


}
