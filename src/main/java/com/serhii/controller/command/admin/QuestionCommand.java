package com.serhii.controller.command.admin;

import com.serhii.controller.command.Command;
import com.serhii.controller.routes.JSPRoutes;

import javax.servlet.http.HttpServletRequest;

public class QuestionCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return JSPRoutes.NEW_QUESTION;
    }
}
