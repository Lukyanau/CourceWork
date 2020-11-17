package by.bntu.coursework.controller.command.impl;

import by.bntu.coursework.controller.command.Command;
import by.bntu.coursework.controller.command.PagePath;
import by.bntu.coursework.entity.User;
import by.bntu.coursework.exception.ServiceException;
import by.bntu.coursework.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class SignInCommand implements Command {
    private final UserServiceImpl userService = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        try {
            String login = request.getParameter("username");
            String password = request.getParameter("password");
            User checkedUser = userService.checkPassword(login, password);
            if (checkedUser != null && checkedUser.getRole() == User.Role.USER) {
                page = PagePath.PASSING_HOME;
            }else if (checkedUser != null && checkedUser.getRole() == User.Role.ADMIN) {
                page = PagePath.PASSING_ABOUT_US;
            } else {
                page = PagePath.SIGN_IN;
                request.setAttribute("errorMessage", "Incorrect login or password");
            }
        } catch (ServiceException exp) {
            page = PagePath.ERROR;
        }
        return page;
    }
}
