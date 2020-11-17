import by.bntu.coursework.connection.ConnectionCreator;
import by.bntu.coursework.dao.impl.UserDaoImpl;
import by.bntu.coursework.exception.DaoException;
import by.bntu.coursework.exception.ServiceException;
import by.bntu.coursework.service.impl.UserServiceImpl;
import by.bntu.coursework.validator.UserValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws DaoException, ServiceException {
        System.out.println(UserValidator.checkSurnameInput(null));
    }

}
