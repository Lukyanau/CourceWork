package by.bntu.coursework.controller.command.impl;

import by.bntu.coursework.controller.command.Command;
import by.bntu.coursework.controller.command.PagePath;
import by.bntu.coursework.creator.UserCreator;
import by.bntu.coursework.exception.DaoException;
import by.bntu.coursework.exception.ServiceException;
import by.bntu.coursework.service.impl.UserServiceImpl;
import by.bntu.coursework.validator.UserValidator;

import javax.servlet.http.HttpServletRequest;

public class SignUpCommand implements Command {
    private final UserServiceImpl userService = UserServiceImpl.getInstance();
    private final UserCreator userCreator = UserCreator.getInstance();


    @Override
    public String execute(HttpServletRequest request) {
        String page;
        try {
            String name = request.getParameter("first_name");
            String surname = request.getParameter("last_name");
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("password_confirmation");
            if (userService.verifyPasswords(password, confirmPassword) && UserValidator.checkSingUpParameters(name, surname, login, password)) {
                userService.signUpUser(userCreator.createUser(login, password, name, surname));
                page = PagePath.NOTIFICATION;
                request.setAttribute("message","Your account successfully created, please sign in");
            } else {
                page = PagePath.PASSING_REGISTRATION;
                request.setAttribute("errorMessage", "Incorrect inputs");
            }
        } catch (ServiceException | DaoException exp) {
            System.out.println(exp.getMessage());
            page = PagePath.ERROR;
        }
        return page;
    }
//    1. Достаем из формы параметры
//            2. Проверяем методом сервиса (отдельным) пароли на соответсвие
//        3. Если пароли совпали, вызываем UserCreator, создаем юзера и кидаем в метод сервиса, который работает с add методом dao,
//    если пароли не соотв-ют то перекидываем заново на эту же страницу регистрации.
}
