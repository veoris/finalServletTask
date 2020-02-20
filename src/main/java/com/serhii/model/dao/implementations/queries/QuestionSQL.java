package com.serhii.model.dao.implementations.queries;

import com.serhii.model.dao.implementations.queries.fieldsdb.QuestionFields;
import com.serhii.model.dao.implementations.queries.fieldsdb.UserFields;
import com.serhii.model.dao.implementations.queries.fieldsdb.UserRolesFields;


public interface QuestionSQL {
    String SAVE = "INSERT INTO `"
            + QuestionFields.TABLE_NAME + "`(`"
            + QuestionFields.TITLE + "`, `"
            + QuestionFields.DESCRIPTION + "`, `"
            + QuestionFields.HELP + "`, `"
            + QuestionFields.ANSWER
            + "`) VALUES ((?), (?), (?), (?))";
    String FIND_ALL = "SELECT * FROM servletdb.question";

}
