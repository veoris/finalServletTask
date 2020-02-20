package com.serhii.controller.command.common;

import com.serhii.controller.command.Command;
import com.serhii.controller.routes.JSPRoutes;
import com.serhii.controller.routes.PageRoutes;
import com.serhii.model.dto.userdto.CheckUserDTO;
import com.serhii.model.dto.userdto.RegistrationUserDTO;
import com.serhii.model.entity.User;
import com.serhii.model.myexceptions.NotUniqueLoginException;
import com.serhii.model.myexceptions.UnacceptableDataInputException;
import com.serhii.service.RegistrationService;
import com.serhii.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {
    private final String NOT_UNIQUE_LOGIN = "?notUniqueLogin=true";
    private final String UNACCAPTABLE_DATA = "?unacceptableData=true";
    private RegistrationService regisrationService = new RegistrationService();
    private UserService userService = new UserService();

    private final static Logger logger = Logger.getLogger(RegisterCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        CheckUserDTO userDTO = new CheckUserDTO();
        userDTO.setLogin(request.getParameter("login"));
        userDTO.setPassword(request.getParameter("password"));
        userDTO.setTeamId(Integer.parseInt(request.getParameter("teamId")));
        logger.info("Trying to register user " + userDTO);
        RegistrationUserDTO validUser;
        try {
            validUser = regisrationService.checkIsValidDataAndReturnValidDTO(userDTO);
        } catch (UnacceptableDataInputException e) {
            logger.warn("User input invalid data");
            return JSPRoutes.REGISTRATION + UNACCAPTABLE_DATA;
        }
        if (regisrationService.checkIsNotCorrectData(validUser)) {
            logger.warn("User input incorrect data");
            return JSPRoutes.REGISTRATION + regisrationService.getURLParams(validUser);
        }
        try {
            userService.saveNewUser(User.builder()
                    .login(validUser.getLogin())
                    .password(validUser.getPassword())
                    .teamId(userDTO.getTeamId())
                    .build());
        } catch (NotUniqueLoginException e) {
            logger.info("User try to register occupied login: " + e.getLoginData());
            return JSPRoutes.REGISTRATION + NOT_UNIQUE_LOGIN;
        }
        return PageRoutes.REDIRECT + request.getServletPath() + PageRoutes.MAIN;
    }
}
