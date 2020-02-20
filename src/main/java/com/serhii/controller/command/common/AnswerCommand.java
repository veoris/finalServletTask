package com.serhii.controller.command.common;

import com.serhii.controller.command.Command;
import com.serhii.controller.routes.JSPRoutes;
import com.serhii.controller.routes.PageRoutes;
import com.serhii.model.dao.implementations.queries.fieldsdb.GameFields;
import com.serhii.model.dao.implementations.queries.fieldsdb.QuestionFields;
import com.serhii.model.dto.userdto.CheckUserDTO;
import com.serhii.model.dto.userdto.RegistrationUserDTO;
import com.serhii.model.entity.User;
import com.serhii.model.myexceptions.NotUniqueLoginException;
import com.serhii.model.myexceptions.UnacceptableDataInputException;
import com.serhii.service.GameService;
import com.serhii.service.RegistrationService;
import com.serhii.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;


public class AnswerCommand implements Command {
    private GameService gameService;

    private final static Logger logger = Logger.getLogger(AnswerCommand.class);
    public AnswerCommand(GameService gameService){this.gameService=gameService;}

    @Override
    public String execute(HttpServletRequest request) {
        try {
            gameService.setAnswer(request.getParameter("answer"), Long.parseLong(request.getParameter("questionId")), Long.parseLong(request.getParameter("id")));
        } catch (RuntimeException e) {
            return JSPRoutes.GAME;
        }
        return PageRoutes.REDIRECT + request.getServletPath() + PageRoutes.GAME;
    }
}
