package com.serhii.model.dao.interfaces;

import com.serhii.model.entity.Game;

import java.util.List;

public interface GameDao extends CRUDDao<Game> {
    Game findGameById(Long id);
    int getLastGameId(String login);
    void setAnswer(String answer, Long gameId, Long questionId);
    void increaseTeamScore(int gameId);
    void increaseViewerScore(int gameId);
    List<Game> findAll();
}
