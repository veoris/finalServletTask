package com.serhii.controller.command.admin;

import com.serhii.controller.command.Command;
import com.serhii.controller.routes.PageRoutes;
import com.serhii.service.GameService;
import javax.servlet.http.HttpServletRequest;

public class WrongCommand implements Command {



    private GameService gameService;

    public WrongCommand(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public String execute(HttpServletRequest request) {

            gameService.increaseViewerScore(106);//TODO

        return PageRoutes.REDIRECT + request.getServletPath() + PageRoutes.MAIN;
    }


}
