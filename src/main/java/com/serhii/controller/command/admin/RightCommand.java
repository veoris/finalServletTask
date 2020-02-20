package com.serhii.controller.command.admin;

import com.serhii.controller.command.Command;
import com.serhii.controller.routes.JSPRoutes;
import com.serhii.controller.routes.PageRoutes;
import com.serhii.model.entity.Question;
import com.serhii.service.GameService;
import com.serhii.service.QuestionService;

import javax.servlet.http.HttpServletRequest;

public class RightCommand implements Command {



    private GameService gameService;

    public RightCommand(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public String execute(HttpServletRequest request) {

            gameService.increaseTeamScore(106);//TODO

        return PageRoutes.REDIRECT + request.getServletPath() + PageRoutes.MAIN;
    }


}
