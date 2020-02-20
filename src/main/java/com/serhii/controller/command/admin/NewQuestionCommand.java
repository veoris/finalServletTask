package com.serhii.controller.command.admin;

import com.serhii.controller.command.Command;
import com.serhii.controller.routes.JSPRoutes;
import com.serhii.controller.routes.PageRoutes;
import com.serhii.model.entity.Question;
import com.serhii.service.QuestionService;

import javax.servlet.http.HttpServletRequest;

public class NewQuestionCommand implements Command {

    private final String TITLE = "title";
    private final String DESCRIPTION = "description";
    private final String HELP = "help";
    private final String ANSWER = "answer";

    private QuestionService questionService;

    public NewQuestionCommand(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        questionService.save(Question.builder()
                .title(request.getParameter(TITLE))
                .description(request.getParameter(DESCRIPTION))
                .help(request.getParameter(HELP))
                .answer(request.getParameter(ANSWER))
                .build());
        return PageRoutes.REDIRECT + request.getServletPath() + PageRoutes.MAIN;
    }


}
