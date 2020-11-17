package by.bntu.coursework.dao;

import by.bntu.coursework.entity.User;
import by.bntu.coursework.exception.DaoException;

public interface UserDao extends BaseDao<User> {
    User findByLogin(String login) throws DaoException;
    User findByLoginAndPassword(String login, String password) throws DaoException;
}
