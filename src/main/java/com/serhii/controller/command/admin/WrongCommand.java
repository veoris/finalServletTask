package com.serhii.controller.command.admin;

import com.serhii.controller.command.Command;
import com.serhii.controller.routes.PageRoutes;
import com.serhii.service.GameService;
import com.serhii.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class WrongCommand implements Command {


    private UserService userService;
    private GameService gameService;

    public WrongCommand(GameService gameService, UserService userService) {
        this.gameService = gameService;
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        gameService.increaseViewerScore(gameService.getLastGameId(userService.getCurrentUser(request).getLogin()));

        return PageRoutes.REDIRECT + request.getServletPath() + PageRoutes.MAIN;
    }


}
