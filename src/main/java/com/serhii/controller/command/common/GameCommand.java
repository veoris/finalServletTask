package com.serhii.controller.command.common;

import com.serhii.controller.command.Command;
import com.serhii.controller.routes.JSPRoutes;
import com.serhii.service.GameService;
import com.serhii.service.QuestionService;
import com.serhii.service.UserService;

import javax.servlet.http.HttpServletRequest;


public class GameCommand implements Command {

    private QuestionService questionService;
    private GameService gameService;
    private UserService userService;

    public GameCommand(QuestionService questionService, GameService gameService, UserService userService) {
        this.questionService = questionService;
        this.gameService = gameService;
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("question", questionService.findForGame());
        request.setAttribute("id", gameService.getLastGameId(userService.getCurrentUser(request).getLogin()));
        return JSPRoutes.GAME;
    }
}
