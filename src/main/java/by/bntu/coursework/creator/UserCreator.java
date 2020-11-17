package by.bntu.coursework.creator;

import by.bntu.coursework.entity.User;

public class UserCreator {
    public static UserCreator instance = new UserCreator();

    private UserCreator() {
    }

    public static UserCreator getInstance() {
        return instance;
    }

    public User createUser(int userId, String login, String password, String name, String surname, int balance) {
        User user = new User(userId, login, password, name, surname, balance);
        return user;
    }

    public User createUser(String login, String password, String name, String surname) {
        User user = new User(login, password, name, surname, "user");
        return user;
    }

    public User createUser(int userId, String login, String password, String name, String surname, int balance, String roleName) {
        User user = new User(userId, login, password, name, surname, balance, roleName.toUpperCase());
        return user;
    }
}
