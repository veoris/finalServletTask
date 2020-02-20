package com.serhii.controller.command.admin;

import com.serhii.controller.command.Command;
import com.serhii.controller.routes.PageRoutes;
import com.serhii.service.GameService;

import javax.servlet.http.HttpServletRequest;


public class NewGameCommand implements Command {

    private GameService gameService;

    public NewGameCommand(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        return PageRoutes.REDIRECT + request.getServletPath() + PageRoutes.ADD_GAME;
    }
}
