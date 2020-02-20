package com.serhii.controller.command.common;

import com.serhii.controller.command.Command;
import com.serhii.controller.routes.PageRoutes;
import com.serhii.service.GameService;
import com.serhii.service.QuestionService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;


public class AnswerCommand implements Command {
    private GameService gameService;
    private QuestionService questionService;

    private final static Logger logger = Logger.getLogger(AnswerCommand.class);

    public AnswerCommand(GameService gameService, QuestionService questionService) {
        this.gameService = gameService;
        this.questionService = questionService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        gameService.setAnswer(request.getParameter("answer"), Long.parseLong(request.getParameter("questionId")), Long.parseLong(request.getParameter("id")));
        questionService.setAnswered(Integer.parseInt(request.getParameter("questionId")));

        return PageRoutes.REDIRECT + request.getServletPath() + PageRoutes.GAME;
    }
}
