package com.serhii.model.dao;

import com.serhii.model.dao.implementations.JDBCDaoFactory;
import com.serhii.model.dao.interfaces.GameDao;
import com.serhii.model.dao.interfaces.QuestionDao;
import com.serhii.model.dao.interfaces.TeamDao;
import com.serhii.model.dao.interfaces.UserDao;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract UserDao createUserDao();

    public abstract QuestionDao createQuestionDao();

    public abstract GameDao createGameDao();

    public abstract TeamDao createTeamDao();


    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    daoFactory = new JDBCDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}

