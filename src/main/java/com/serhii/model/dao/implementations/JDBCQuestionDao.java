package com.serhii.model.dao.implementations;

import com.serhii.model.dao.implementations.queries.QuestionSQL;
import com.serhii.model.dao.interfaces.QuestionDao;
import com.serhii.model.dao.mapper.Mapper;
import com.serhii.model.dao.mapper.implementations.QuestionMapper;
import com.serhii.model.entity.Question;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCQuestionDao implements QuestionDao {
    private Connection connection;

    private final static Logger logger = Logger.getLogger(JDBCQuestionDao.class);

    public JDBCQuestionDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Question findById(Long id) {
        Mapper<Question> questionMapper = new QuestionMapper();
        Question found = new Question();
        try (PreparedStatement ps = connection.prepareStatement("select  * from questions where questions.id=?1")) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                found = questionMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            logger.error("SQLException occurred", e);
            throw new RuntimeException(e);
        }
        return found;
    }

    @Override
    public void create(Question entity) {
        try(PreparedStatement ps = connection.prepareStatement(QuestionSQL.SAVE, Statement.RETURN_GENERATED_KEYS)){
            connection.setAutoCommit(false);
            ps.setString(1, entity.getTitle());
            ps.setString(2, entity.getDescription());
            ps.setString(3, entity.getHelp());
            ps.setString(4, entity.getAnswer());
            logger.debug("Executing SQL query:" + QuestionSQL.SAVE + " for " + entity);
            ps.executeUpdate();
            connection.commit();
        }catch (SQLException e){
            logger.error("Occurred SQLException", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Question findById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Question> findAll() {
        Mapper<Question> mapper = new QuestionMapper();
        List<Question> questions = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(QuestionSQL.FIND_ALL)) {
            logger.debug("Executing SQL query:" + QuestionSQL.FIND_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                questions.add(mapper.getEntity(rs));
            }
        } catch (SQLException e) {
            logger.error("Occurred SQLException", e);
            throw new RuntimeException(e);
        }
        return questions;
    }

    @Override
    public Question findForGame() {
        Mapper<Question> questionMapper = new QuestionMapper();
        Question found = new Question();
        try (PreparedStatement ps = connection.prepareStatement("select  * from question where answered=0 limit 1")) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                found = questionMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            logger.error("SQLException occurred", e);
            throw new RuntimeException(e);
        }
        return found;
    }

    @Override
    public void update(Question entity) {
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
