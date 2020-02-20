package com.serhii.controller.command.common;

import com.serhii.controller.command.Command;
import com.serhii.controller.routes.JSPRoutes;
import com.serhii.service.TeamService;
import com.serhii.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements Command {
    private TeamService teamService;

    public RegistrationCommand(TeamService teamService){
        this.teamService = teamService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("teams",teamService.findAll());
        return JSPRoutes.REGISTRATION;
    }
}
