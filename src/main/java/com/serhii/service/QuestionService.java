package com.serhii.service;

import com.serhii.model.dao.DaoFactory;
import com.serhii.model.dao.interfaces.QuestionDao;
import com.serhii.model.entity.Question;
import org.apache.log4j.Logger;

public class QuestionService {
    private final static Logger logger = Logger.getLogger(QuestionService.class);
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public Question findForGame() {
        try (QuestionDao dao = daoFactory.createQuestionDao()) {
            return dao.findForGame();
        }
    }

    public void save(Question question) {
        try (QuestionDao dao = daoFactory.createQuestionDao()) {
            dao.create(question);
        }
        logger.debug("Saved new question " + question);
    }

    public void setAnswered(int id) {
        try (QuestionDao dao = daoFactory.createQuestionDao()) {
            dao.setAnswered(id);
        }
    }
}
