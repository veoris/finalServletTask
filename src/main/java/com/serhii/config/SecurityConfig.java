package com.serhii.config;

import com.serhii.controller.routes.PageRoutes;
import com.serhii.model.entity.Role;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecurityConfig {
    private static Map<Role, List<String>> securedPages = new HashMap<>();

    static {
        init();
    }

    private static void init() {
        securedPages.put(Role.GUEST, Arrays.asList(
                PageRoutes.MAIN,
                PageRoutes.LOGIN,
                PageRoutes.AUTH,
                PageRoutes.REGISTRATION,
                PageRoutes.REGISTER

        ));
        securedPages.put(Role.USER, Arrays.asList(
                PageRoutes.MAIN,
                PageRoutes.USER_PAGE,
                PageRoutes.LOGOUT,

                PageRoutes.GAME,
                PageRoutes.QUESTION,
                PageRoutes.ANSWER

        ));

        securedPages.put(Role.ADMIN, Arrays.asList(
                PageRoutes.MAIN,
                PageRoutes.USER_PAGE,
                PageRoutes.LOGOUT,
                PageRoutes.ADMIN,
                PageRoutes.ADD_QUESTION,
                PageRoutes.CONFIRM,
                PageRoutes.RIGHT,
                PageRoutes.WRONG

        ));
    }

    public static List<String> getSecuredPagesForRole(Role role) {
        return securedPages.get(role);
    }

}
