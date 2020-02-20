package com.serhii.model.dao.mapper.implementations;

import com.serhii.model.dao.implementations.queries.fieldsdb.QuestionFields;
import com.serhii.model.dao.mapper.Mapper;
import com.serhii.model.entity.Question;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements Mapper<Question> {
    @Override
    public Question getEntity(ResultSet resultSet) throws SQLException {
        return Question.builder()
                .id(resultSet.getLong(QuestionFields.ID))
                .title(resultSet.getString(QuestionFields.TITLE))
                .description(resultSet.getString(QuestionFields.DESCRIPTION))
                .answer(resultSet.getString(QuestionFields.ANSWER))
                .help(resultSet.getString(QuestionFields.HELP))
                .answered(resultSet.getBoolean(QuestionFields.ANSWERED))
                .build();
    }
}
