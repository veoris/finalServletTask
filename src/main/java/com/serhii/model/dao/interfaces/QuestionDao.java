package com.serhii.model.dao.interfaces;

import com.serhii.model.entity.Question;

import java.util.List;

public interface QuestionDao extends CRUDDao<Question> {
    void setAnswered(int id);

    List<Question> findAll();

    Question findForGame();
}
