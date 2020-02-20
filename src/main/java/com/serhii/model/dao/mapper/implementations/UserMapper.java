package com.serhii.model.dao.mapper.implementations;

import com.serhii.model.dao.implementations.queries.fieldsdb.UserFields;
import com.serhii.model.dao.mapper.Mapper;
import com.serhii.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements Mapper<User> {
    @Override
    public User getEntity(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getInt(UserFields.ID))
                .login(resultSet.getString(UserFields.LOGIN))
                .password(resultSet.getString(UserFields.PASSWORD))
                .build();
    }
}
