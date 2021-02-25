package by.bntu.coursework.service.impl;

import by.bntu.coursework.dao.impl.UserDaoImpl;
import by.bntu.coursework.entity.User;
import by.bntu.coursework.exception.DaoException;
import by.bntu.coursework.exception.ServiceException;
import by.bntu.coursework.service.UserService;
import by.bntu.coursework.validator.UserValidator;

public class UserServiceImpl implements UserService {

    private static final UserServiceImpl instance = new UserServiceImpl();


    private UserServiceImpl() {

    }

    public static UserServiceImpl getInstance() {
        return instance;
    }

    @Override
    public User checkPassword(String login, String password) throws ServiceException {
        User user;
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        if (!UserValidator.checkLoginInput(login) && !UserValidator.checkPasswordInput(password)) {
           throw new ServiceException("Incorrect input of login and password");
        }
        try {
            user = userDao.findByLoginAndPassword(login, password);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
        return user;
    }

    @Override
    public boolean signUpUser(User signUpUser) throws ServiceException {
        boolean isAdded;
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        try {
            isAdded = userDao.add(signUpUser);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
        return isAdded;
    }

    public boolean verifyPasswords(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }


}
