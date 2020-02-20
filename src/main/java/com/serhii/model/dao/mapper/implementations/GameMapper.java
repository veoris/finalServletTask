package com.serhii.model.dao.mapper.implementations;

import com.serhii.model.dao.implementations.queries.fieldsdb.GameFields;
import com.serhii.model.dao.mapper.Mapper;
import com.serhii.model.entity.Game;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GameMapper implements Mapper<Game> {
    @Override
    public Game getEntity(ResultSet resultSet) throws SQLException {
        return Game.builder()
                .id(resultSet.getInt(GameFields.ID))
                .teamId(resultSet.getLong(GameFields.TEAM_ID))
                .viewerScore(resultSet.getInt(GameFields.VIEWER_SCORE))
                .teamScore(resultSet.getInt(GameFields.TEAM_SCORE))
                .currentAnswer(resultSet.getString(GameFields.CURRENT_ANSWER))
                .currentQuestionId(resultSet.getLong(GameFields.CURRENT_ANSWER_ID))
                .build();
    }
}
