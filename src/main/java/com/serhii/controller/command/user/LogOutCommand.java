package com.serhii.controller.command.user;

import com.serhii.controller.command.Command;
import com.serhii.controller.routes.PageRoutes;

import javax.servlet.http.HttpServletRequest;

public class LogOutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return PageRoutes.REDIRECT + request.getServletPath() + PageRoutes.MAIN;
    }
}
