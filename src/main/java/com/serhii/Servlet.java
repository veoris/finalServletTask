package com.serhii;

import com.serhii.controller.command.Command;
import com.serhii.controller.command.admin.*;
import com.serhii.controller.command.common.*;
import com.serhii.controller.command.user.LogOutCommand;
import com.serhii.controller.routes.PageRoutes;
import com.serhii.service.GameService;
import com.serhii.service.QuestionService;
import com.serhii.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class Servlet extends javax.servlet.http.HttpServlet {
    private Map<String, Command> commands = new HashMap<>();
    private final Logger logger = Logger.getLogger(Servlet.class);

    public void init(ServletConfig servletConfig) {
        servletConfig.getServletContext()
                .setAttribute("loggedUsers", new HashSet<String>());
        commands.put("registration",
                new RegistrationCommand());
        commands.put("login",
                new LoginCommand());
        commands.put("logout",
                new LogOutCommand());
        commands.put("register",
                new RegisterCommand());
        commands.put("main",
                new MainCommand());
        commands.put("auth",
                new AuthCommand());
        commands.put("admin",
                new AdminCommand(new QuestionService()));
        commands.put("question",
                new QuestionCommand());
        commands.put("addquestion",
                new NewQuestionCommand(new QuestionService()));
        commands.put("game",
                new GameCommand(new QuestionService(), new GameService(), new UserService()));
        commands.put("answer",
                new AnswerCommand(new GameService(), new QuestionService()));
        commands.put("confirm",
                new ConfirmCommand(new GameService()));
        commands.put("right",
                new RightCommand(new GameService(), new UserService()));
        commands.put("wrong",
                new WrongCommand(new GameService(), new UserService()));


    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getRequestURI();
        path = path.replaceAll(".*/app/", "");
        Command command = commands.getOrDefault(path, new MainCommand());
        String page = command.execute(request);
        if (page.contains(PageRoutes.REDIRECT)) {
            logger.debug("Redirecting to " + page);
            response.sendRedirect(page.replace(PageRoutes.REDIRECT, ""));
        } else {
            logger.debug("Forwarding to " + page);
            request.getRequestDispatcher(request.getContextPath() + page).forward(request, response);
        }
    }

}
