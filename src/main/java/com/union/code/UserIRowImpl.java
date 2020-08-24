package com.union.code;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author Mr.Cheng
 * @date 2020/8/21
 */
public class UserIRowImpl implements IRow {
    @Override
    public List<User> mapping(ResultSet resultSet) {
        List<User> userList = null;
        try {
            userList = new ArrayList<>();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
