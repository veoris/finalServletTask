package com.serhii.model.dao.implementations;

import com.serhii.model.dao.DaoFactory;
import com.serhii.model.dao.interfaces.GameDao;
import com.serhii.model.dao.interfaces.QuestionDao;
import com.serhii.model.dao.interfaces.TeamDao;
import com.serhii.model.dao.interfaces.UserDao;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {
    private DataSource dataSource = ConnectionPoolHolder.getDataSource();
    private final static Logger logger = Logger.getLogger(JDBCDaoFactory.class);

    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }

    @Override
    public QuestionDao createQuestionDao() {
        return new JDBCQuestionDao(getConnection());
    }

    @Override
    public GameDao createGameDao() {
        return new JDBCGameDao(getConnection());
    }

    @Override
    public TeamDao createTeamDao() {
        return new JDBCTeamDao(getConnection());
    }


    private Connection getConnection() {
        try {
            logger.debug("Getting connection to DB");
            return dataSource.getConnection();
        } catch (SQLException e) {
            logger.error("Cannot get connection to db");
            throw new RuntimeException(e);
        }
    }
}
