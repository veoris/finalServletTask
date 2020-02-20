package com.serhii.service;

import com.serhii.model.dto.userdto.CheckUserDTO;
import com.serhii.model.dto.userdto.RegistrationUserDTO;
import com.serhii.model.myexceptions.UnacceptableDataInputException;
import org.apache.log4j.Logger;

public class RegistrationService {
    private final String AND = "&";
    private final String EQ = "=";
    private final String LOGINREGEX = "^[a-zA-Z0-9]{3,20}$";
    private final String PASSREGEX = "^[a-zA-Z0-9]{3,20}$";
    private final String CHECKLOGIN = "checkLogin";
    private final String CHECKPASSWORD = "checkPassword";
    private final String LOGIN = "login";

    private final static Logger logger = Logger.getLogger(RegistrationService.class);


    private boolean isLoginCorrect(String login) {
        return login.matches(LOGINREGEX);
    }

    private boolean isPasswordCorrect(String password) {
        return password.matches(PASSREGEX);
    }

    public boolean checkIsNotCorrectData(RegistrationUserDTO user) {
        logger.debug("Checking is data correct");
        return !(isLoginCorrect(user.getLogin())
                && isPasswordCorrect(user.getPassword()));
    }

    public String getURLParams(RegistrationUserDTO user) {
        logger.debug("Returning URL Params");
        return "?"
                + CHECKLOGIN + EQ + isLoginCorrect(user.getLogin()) + AND + LOGIN + EQ + user.getLogin()
                + AND + CHECKPASSWORD + EQ + isPasswordCorrect(user.getPassword());
    }

    public RegistrationUserDTO checkIsValidDataAndReturnValidDTO(CheckUserDTO userDTO) throws UnacceptableDataInputException {
        logger.debug("Checking is data valid");
        RegistrationUserDTO user = new RegistrationUserDTO();
        try {

        } catch (Exception e) {
            logger.error("Invalid data input", e);
            throw new UnacceptableDataInputException(e);
        }
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        return user;
    }
}
