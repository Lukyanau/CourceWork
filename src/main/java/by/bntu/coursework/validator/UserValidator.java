package by.bntu.coursework.validator;

import by.bntu.coursework.dao.impl.UserDaoImpl;
import by.bntu.coursework.exception.DaoException;
import by.bntu.coursework.service.impl.UserServiceImpl;

import java.util.regex.Pattern;

public class UserValidator {

    private static final String LOGIN_REGEX = "^[a-zA-Z0-9_]{3,20}$";
    private static final String PASSWORD_REGEX = LOGIN_REGEX;
    private static final String NAME_REGEX = "^[a-zA-Z]{3,20}$";
    private static final String SURNAME_REGEX = "^[a-zA-Z]{3,20}$";

    public static boolean checkLoginInput(String str) {
        return isEmptyOrNull(str) && str.matches(LOGIN_REGEX) ;
    }

    public static boolean checkPasswordInput(String str) {
        return isEmptyOrNull(str) && str.matches(PASSWORD_REGEX);
    }

    public static boolean checkNameInput(String str) {
        return isEmptyOrNull(str) && str.matches(NAME_REGEX);
    }

    public static boolean checkSurnameInput(String str) {
        return isEmptyOrNull(str) && str.matches(SURNAME_REGEX);
    }

    public static boolean checkSingUpParameters(String name, String surname, String login, String password) throws DaoException {
        return checkNameInput(name) && checkSurnameInput(surname)
                && checkLoginInput(login) && checkLoginUnique(login) && checkPasswordInput(password);
    }

    private static boolean isEmptyOrNull(String str) {
        return str != null && !str.isEmpty();
    }

    private static boolean checkLoginUnique(String str) throws DaoException {
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        return userDao.checkLoginUnique(str);
    }

}

