package com.serhii.model.dao.implementations.queries;

import com.serhii.model.dao.implementations.queries.fieldsdb.QuestionFields;


public interface QuestionSQL {
    String SAVE = "INSERT INTO `"
            + QuestionFields.TABLE_NAME + "`(`"
            + QuestionFields.TITLE + "`, `"
            + QuestionFields.DESCRIPTION + "`, `"
            + QuestionFields.HELP + "`, `"
            + QuestionFields.ANSWER
            + "`) VALUES ((?), (?), (?), (?))";
    String FIND_ALL = "SELECT * FROM servletdb.question";
    String SET_ANSWERED = "update question set answered=true where id=(?)";
    String FIND_FOR_GAME = "select  * from question where answered=0 limit 1";

}
