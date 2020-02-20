package com.serhii.model.dao.implementations.queries;

import com.serhii.model.dao.implementations.queries.fieldsdb.TeamFields;

public interface TeamSQL {
    String SAVE = "INSERT INTO `"
            + TeamFields.TABLE_NAME + "`(`"
            + TeamFields.NAME + "`, `"
            + "`) VALUES (?)";
    String FIND_ALL = "SELECT * FROM servletdb.team;";

}
