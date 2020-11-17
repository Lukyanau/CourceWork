package by.bntu.coursework.service;

import by.bntu.coursework.entity.User;
import by.bntu.coursework.exception.ServiceException;

public interface UserService {
    User checkPassword(String login, String password) throws ServiceException;
    boolean signUpUser(User user) throws ServiceException;

}
