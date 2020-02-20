package com.serhii.controller.command.admin;

import com.serhii.controller.command.Command;
import com.serhii.controller.routes.JSPRoutes;
import com.serhii.service.GameService;

import javax.servlet.http.HttpServletRequest;

public class ConfirmCommand implements Command {
    private GameService gameService;
    public ConfirmCommand(GameService gameService){this.gameService=gameService;}
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("game", gameService.findGameByID(106));//TODO
        return JSPRoutes.CONFIRM;
    }
}
