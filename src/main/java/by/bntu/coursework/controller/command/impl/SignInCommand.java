package by.bntu.coursework.controller.command.impl;

import by.bntu.coursework.controller.command.Command;
import by.bntu.coursework.controller.command.PagePath;
import by.bntu.coursework.entity.User;
import by.bntu.coursework.exception.ServiceException;
import by.bntu.coursework.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SignInCommand implements Command {
    private final UserServiceImpl userService = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String page;
        try {
            String login = request.getParameter("username");
            String password = request.getParameter("password");
            User checkedUser = userService.checkPassword(login, password);
            if (checkedUser == null) {
                page = PagePath.SIGN_IN;
                request.setAttribute("errorMessage", "Incorrect login or password");
            } else {
                User.Role currentRole = checkedUser.getRole();
                session.setAttribute("sessionRole", currentRole);
                session.setAttribute("sessionUser", checkedUser);
                page = PagePath.PASSING_HOME;
            }
        } catch (ServiceException exp) {
            page = PagePath.ERROR;
        }
        return page;
    }
}
