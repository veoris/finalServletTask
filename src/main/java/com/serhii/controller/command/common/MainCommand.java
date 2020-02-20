package com.serhii.controller.command.common;

import com.serhii.controller.command.Command;
import com.serhii.controller.routes.JSPRoutes;

import javax.servlet.http.HttpServletRequest;

public class MainCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return JSPRoutes.MAIN;
    }
}
