package com.serhii.controller.command.user;

import com.serhii.controller.command.Command;
import com.serhii.controller.routes.JSPRoutes;
import com.serhii.model.entity.Role;
import com.serhii.model.entity.User;
import com.serhii.service.GameService;
import com.serhii.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class UserPageCommand implements Command {
    private final String TODAY_EATEN = "todayEaten";
    private final String IS_ADMIN = "isAdmin";
    private final String IS_NORM_EXCEEDED = "isNormExceeded";
    private UserService userService;
    private GameService gameService;

    public UserPageCommand(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        User currentUser = userService.getCurrentUser(request);
        request.getSession().setAttribute(IS_ADMIN, currentUser.getRoles().contains(Role.ADMIN));
        return JSPRoutes.USER_PAGE;
    }
}
