package by.bntu.coursework.dao.impl;

import by.bntu.coursework.connection.ConnectionCreator;
import by.bntu.coursework.creator.UserCreator;
import by.bntu.coursework.dao.SqlQuery;
import by.bntu.coursework.dao.UserDao;
import by.bntu.coursework.entity.User;
import by.bntu.coursework.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final UserDaoImpl instance = new UserDaoImpl();


    public static UserDaoImpl getInstance() {
        return instance;
    }


    @Override
    public User findByLogin(String login) throws DaoException {
        UserCreator userCreator = UserCreator.getInstance();
        try (Connection connection = new ConnectionCreator().getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.FIND_BY_LOGIN)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                String userLogin = resultSet.getString("login");
                String userPassword = resultSet.getString("password");
                String userName = resultSet.getString("name");
                String userSurname = resultSet.getString("surname");
                int userBalance = resultSet.getInt("balance");
                user = userCreator.createUser(userId, userLogin, userPassword, userName, userSurname, userBalance);

            }
            return user;
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }

    }

    @Override
    public User findByLoginAndPassword(String login, String password) throws DaoException {
        UserCreator userCreator = UserCreator.getInstance();
        try (Connection connection = new ConnectionCreator().getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.FIND_BY_LOGIN_AND_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                String userLogin = resultSet.getString("login");
                String userPassword = resultSet.getString("password");
                String userName = resultSet.getString("name");
                String userSurname = resultSet.getString("surname");
                int userBalance = resultSet.getInt("balance");
                String nameRole = resultSet.getString("roleName");
                user = userCreator.createUser(userId, userLogin, userPassword, userName, userSurname, userBalance, nameRole);
            }
            return user;
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
    }

    @Override
    public boolean add(User user) throws DaoException {
        boolean isAdded;
        try (Connection connection = new ConnectionCreator().getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.ADD_USER)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurname());
            statement.setInt(5, user.getBalance());
            statement.setString(6, user.getRole().getNameRole());
            isAdded = statement.executeUpdate() > 0;
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return isAdded;
    }

    @Override
    public User remove(int id) throws DaoException {
        return null;
    }

    @Override
    public List<User> findAll() throws DaoException {
        List<User> foundUsers = new ArrayList<>();
        UserCreator userCreator = UserCreator.getInstance();
        try (Connection connection = new ConnectionCreator().getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.FIND_ALL_USERS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                String userLogin = resultSet.getString("login");
                String userPassword = resultSet.getString("password");
                String userName = resultSet.getString("name");
                String userSurname = resultSet.getString("surname");
                int userBalance = resultSet.getInt("balance");
                User user = userCreator.createUser(userId, userLogin, userPassword, userName, userSurname, userBalance);
                foundUsers.add(user);
            }
            return foundUsers;

        } catch (SQLException exp) {
            throw new DaoException(exp);
        }

    }

    public boolean checkLoginUnique(String login) throws DaoException {
        try (Connection connection = new ConnectionCreator().getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.CHECK_UNIQUE_LOGIN)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println(false);
                return false;
            }
            System.out.println(true);
            return true;
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }

    }
}
