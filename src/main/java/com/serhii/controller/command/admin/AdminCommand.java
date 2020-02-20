package com.serhii.controller.command.admin;

import com.serhii.controller.command.Command;
import com.serhii.controller.routes.JSPRoutes;
import com.serhii.service.QuestionService;

import javax.servlet.http.HttpServletRequest;


public class AdminCommand implements Command {

    private QuestionService questionService;

    public AdminCommand(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        return JSPRoutes.ADMIN;
    }
}
