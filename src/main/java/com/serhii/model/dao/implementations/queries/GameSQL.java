package com.serhii.model.dao.implementations.queries;


import com.serhii.model.dao.implementations.queries.fieldsdb.GameFields;

public interface GameSQL {
    String SAVE = "INSERT INTO `"
            + GameFields.TABLE_NAME + "`(`"
            + GameFields.TEAM_ID + "`, `"
            + "`) VALUES (?)";
    String FIND_BY_ID = "SELECT * FROM `" + GameFields.TABLE_NAME + "`WHERE`" + GameFields.ID + "`=(?)";
    String SET_ANSWER = "UPDATE `servletdb`.`game` SET `current_answer` = (?), `current_question_id` = (?) WHERE (`id` = (?));";
    String INCREASE_TEAM_SCORE = "UPDATE `servletdb`.`game` SET `team_score` = `team_score`+1 WHERE (`id` = (?))";
    String INCREASE_VIEWER_SCORE = "UPDATE `servletdb`.`game` SET `viewer_score` = `viewer_score`+1 WHERE (`id` = (?))";
    String GET_LAST_GAME_ID = "select game.* from game join team on game.team_id=team.id join user on team.id=user.team_id and user.login =(?) where game.ended=false  order by game.id desc limit 1";

}
