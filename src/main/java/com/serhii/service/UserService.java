package com.serhii.service;

import com.serhii.model.dao.DaoFactory;
import com.serhii.model.dao.interfaces.UserDao;
import com.serhii.model.dto.userdto.LoginUserDTO;
import com.serhii.model.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;


public class UserService {
    private final static Logger logger = Logger.getLogger(UserService.class);
    private final String USER = "user";
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public void saveNewUser(User user) {
        try (UserDao dao = daoFactory.createUserDao()) {
            dao.create(user);
        }
        logger.info("Saved new user " + user);
    }

    public User auth(LoginUserDTO user) {
        logger.info("Try to Auth" + user);
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.findUserByLoginAndPassword(user);
        }
    }


    public User getCurrentUser(HttpServletRequest request) {
        logger.debug("Getting current user");
        return (User) request.getSession().getAttribute(USER);
    }
}
