package com.serhii.controller.command.user;

import com.serhii.controller.command.Command;
import com.serhii.controller.routes.JSPRoutes;
import com.serhii.model.entity.Role;
import com.serhii.model.entity.User;
import com.serhii.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class UserPageCommand implements Command {
    private final String IS_ADMIN = "isAdmin";
    private UserService userService;

    public UserPageCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        User currentUser = userService.getCurrentUser(request);
        request.getSession().setAttribute(IS_ADMIN, currentUser.getRoles().contains(Role.ADMIN));
        return JSPRoutes.USER_PAGE;
    }
}
