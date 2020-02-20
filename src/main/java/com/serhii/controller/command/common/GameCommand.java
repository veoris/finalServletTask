package com.serhii.controller.command.common;

import com.serhii.controller.command.Command;
import com.serhii.controller.routes.JSPRoutes;
import com.serhii.service.GameService;
import com.serhii.service.QuestionService;
import javax.servlet.http.HttpServletRequest;

public class GameCommand implements Command {

    private QuestionService questionService;
    private GameService gameService;

    public GameCommand(QuestionService questionService, GameService gameService){this.questionService=questionService; this.gameService=gameService;}

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("question",questionService.findForGame());
        request.setAttribute("id",106);//TODO
        return JSPRoutes.GAME;
    }
}
