package com.serhii.controller.command.common;

import com.serhii.controller.command.Command;
import com.serhii.controller.routes.JSPRoutes;
import com.serhii.controller.routes.PageRoutes;
import com.serhii.model.dto.userdto.LoginUserDTO;
import com.serhii.model.entity.User;
import com.serhii.service.UserService;

import javax.servlet.http.HttpServletRequest;


public class AuthCommand implements Command {
    private UserService userService = new UserService();
    private final String WRONGINPUTTRUE = "?wrongInput=true";

    @Override
    public String execute(HttpServletRequest request) {
        LoginUserDTO userDTO = new LoginUserDTO(
                request.getParameter("login"),
                request.getParameter("password"));
        User user = userService.auth(userDTO);
        if (user.getLogin() != null) {
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("userid", user.getId());
            return PageRoutes.REDIRECT + request.getServletPath() + PageRoutes.USER_PAGE;
        }
        return JSPRoutes.LOGIN + WRONGINPUTTRUE;
    }
}
