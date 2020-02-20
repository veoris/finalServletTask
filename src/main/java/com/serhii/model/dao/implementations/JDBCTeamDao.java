package com.serhii.model.dao.implementations;

import com.serhii.model.dao.implementations.queries.QuestionSQL;
import com.serhii.model.dao.implementations.queries.TeamSQL;
import com.serhii.model.dao.interfaces.TeamDao;
import com.serhii.model.dao.mapper.Mapper;
import com.serhii.model.dao.mapper.implementations.QuestionMapper;
import com.serhii.model.dao.mapper.implementations.TeamMapper;
import com.serhii.model.entity.Question;
import com.serhii.model.entity.Team;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCTeamDao implements TeamDao {
    private Connection connection;

    private final static Logger logger = Logger.getLogger(JDBCTeamDao.class);

    public JDBCTeamDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(Team entity) {
        try (PreparedStatement ps = connection.prepareStatement(TeamSQL.SAVE)) {
            connection.setAutoCommit(false);
            ps.setString(1, entity.getName());
            logger.debug("Executing SQL query:" + TeamSQL.SAVE + " for " + entity);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            logger.error("Occurred SQLException", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Team findById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Team> findAll() {
        Mapper<Team> mapper = new TeamMapper();
        List<Team> teams = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(TeamSQL.FIND_ALL)) {
            logger.debug("Executing SQL query:" +TeamSQL.FIND_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                teams.add(mapper.getEntity(rs));
            }
        } catch (SQLException e) {
            logger.error("Occurred SQLException", e);
            throw new RuntimeException(e);
        }
        return teams;
    }

    @Override
    public void update(Team entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void close() {
        logger.debug("Closing connection");
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error("SQLException occurred", e);
            throw new RuntimeException(e);
        }
    }
}
