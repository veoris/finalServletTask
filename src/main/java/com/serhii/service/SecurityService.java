package com.serhii.service;

import com.serhii.config.SecurityConfig;
import com.serhii.controller.routes.PageRoutes;
import com.serhii.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class SecurityService {
    public static boolean hasPermission(HttpServletRequest request, User user) {
        return user.getRoles().stream()
                .anyMatch(r -> SecurityConfig.getSecuredPagesForRole(r)
                        .contains(Optional.ofNullable(request.getPathInfo()).orElse(PageRoutes.MAIN)));
    }
}
