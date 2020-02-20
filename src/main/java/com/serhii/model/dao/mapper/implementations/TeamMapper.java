package com.serhii.model.dao.mapper.implementations;

import com.serhii.model.dao.implementations.queries.fieldsdb.TeamFields;
import com.serhii.model.dao.mapper.Mapper;
import com.serhii.model.entity.Team;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamMapper implements Mapper<Team> {
    @Override
    public Team getEntity(ResultSet resultSet) throws SQLException {
        return Team.builder()
                .id(resultSet.getLong(TeamFields.ID))
                .name(resultSet.getString(TeamFields.NAME))
                .build();

    }
}
