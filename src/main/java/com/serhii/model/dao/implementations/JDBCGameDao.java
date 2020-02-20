package com.serhii.model.dao.implementations;

import com.serhii.model.dao.implementations.queries.GameSQL;
import com.serhii.model.dao.interfaces.GameDao;
import com.serhii.model.dao.mapper.Mapper;
import com.serhii.model.dao.mapper.implementations.GameMapper;
import com.serhii.model.entity.Game;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDBCGameDao implements GameDao {
    private Connection connection;

    private final static Logger logger = Logger.getLogger(JDBCGameDao.class);

    public JDBCGameDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Game findGameById(Long id) {
        Mapper<Game> gameMapper = new GameMapper();
        Game found = new Game();
        try (PreparedStatement ps = connection.prepareStatement(GameSQL.FIND_BY_ID)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                found = gameMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            logger.error("SQLException occurred", e);
            throw new RuntimeException(e);
        }
        return found;
    }

    @Override
    public void setAnswer(String answer, Long id, Long questionId) {
        try(PreparedStatement ps = connection.prepareStatement(GameSQL.SET_ANSWER)){
            ps.setString(1, answer);
            ps.setLong(2,questionId);
            ps.setLong(3, id);
            ps.executeUpdate();
        }catch (SQLException e){
            logger.error("Occurred SQLException", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void increaseTeamScore(int gameId) {
        try(PreparedStatement ps = connection.prepareStatement(GameSQL.INCREASE_TEAM_SCORE)){
            ps.setInt(1, gameId);
            ps.executeUpdate();
        }catch (SQLException e){
            logger.error("Occurred SQLException", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void increaseViewerScore(int gameId) {
        try(PreparedStatement ps = connection.prepareStatement(GameSQL.INCREASE_VIEWER_SCORE)){
            ps.setInt(1, gameId);
            ps.executeUpdate();
        }catch (SQLException e){
            logger.error("Occurred SQLException", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Game entity) {
        try(PreparedStatement ps = connection.prepareStatement(GameSQL.SAVE)){
            ps.setLong(1, entity.getTeamId());
            logger.debug("Executing SQL query:" + GameSQL.SAVE + " for " + entity);
            ps.executeUpdate();
        }catch (SQLException e){
            logger.error("Occurred SQLException", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Game findById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Game> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Game entity) {
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
