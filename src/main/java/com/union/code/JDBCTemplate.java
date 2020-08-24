package com.union.code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author Mr.Cheng
 * @date 2020/8/20
 */
public class JDBCTemplate {

    //初步优化为可以查询userList的方法
    public static List<User> query(String sql, Object... params) throws SQLException {
        Connection connection = JDBCUtils.connection();
        PreparedStatement ps = connection.prepareStatement(sql);
        /*sql的？参数赋值*/
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
        ResultSet resultSet = ps.executeQuery();
        List<User> userList = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt(1));
            user.setUsername(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setNickname(resultSet.getString(4));
            user.setQuestion(resultSet.getString(5));
            user.setAnswer(resultSet.getString(6));
            user.setGmtCreate(resultSet.getDate(7));
            user.setGmtModified(resultSet.getDate(8));
            userList.add(user);
        }
        return userList;
    }

    //初步优化为可以查询userList的方法
    public static <T> T query(String sql, IRow row, Object... params) throws SQLException {
        Connection connection = JDBCUtils.connection();
        PreparedStatement ps = connection.prepareStatement(sql);
        /*sql的？参数赋值*/
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
        ResultSet resultSet = ps.executeQuery();
        //查询后的集合由实现接口的类去实现
        return row.mapping(resultSet);
        /*List<User> userList = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt(1));
            user.setUsername(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setNickname(resultSet.getString(4));
            user.setQuestion(resultSet.getString(5));
            user.setAnswer(resultSet.getString(6));
            user.setGmtCreate(resultSet.getDate(7));
            user.setGmtModified(resultSet.getDate(8));
            userList.add(user);
        }*/
    }


}
