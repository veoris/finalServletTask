package com.serhii.service;

import com.serhii.model.dao.DaoFactory;
import com.serhii.model.dao.interfaces.GameDao;
import com.serhii.model.entity.Game;
import org.apache.log4j.Logger;

import java.util.List;


public class GameService {
    private final static Logger logger = Logger.getLogger(GameService.class);
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Game> findAll() {
        try (GameDao dao = daoFactory.createGameDao()) {
            return dao.findAll();
        }
    }

    public Game findGameByID(int id) {
        try (GameDao dao = daoFactory.createGameDao()) {
            return dao.findGameById((long) id);
        }
    }


    public void setAnswer(String answer, Long gameId, Long questionId) {
        try (GameDao dao = daoFactory.createGameDao()) {
            dao.setAnswer(answer, questionId, gameId);
        }
        logger.debug("Saved new game " + answer);
    }

    public void increaseTeamScore(int gameId) {
        try (GameDao dao = daoFactory.createGameDao()) {
            dao.increaseTeamScore(gameId);
        }
    }

    public void increaseViewerScore(int gameId) {
        try (GameDao dao = daoFactory.createGameDao()) {
            dao.increaseViewerScore(gameId);
        }
    }

    public int getLastGameId(String login) {
        try (GameDao dao = daoFactory.createGameDao()) {
            return dao.getLastGameId(login);
        }
    }

}
