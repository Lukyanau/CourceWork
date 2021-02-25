package by.bntu.coursework.entity;

import java.util.Objects;

public class User extends Entity {
    public enum Role {
        ADMIN("admin"),
        USER("user");

        private final String nameRole;

        Role(String nameRole) {
            this.nameRole = nameRole;
        }

        public String getNameRole() {
            return nameRole;
        }
    }

    private int userId;
    private String login;
    private String password;
    private String name;
    private String surname;
    private int balance;
    private Role role;

    public User(int userId, String login, String password, String name, String surname, int balance) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
    }
    public User(String login, String password, String name, String surname, int balance,String roleName) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.role = Role.valueOf(roleName.toUpperCase());
    }

    public User(int userId, String login, String password, String name, String surname, int balance, String roleName) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.role = Role.valueOf(roleName.toUpperCase());
    }

    public User(String login, String password, String name, String surname, String roleName) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = Role.valueOf(roleName.toUpperCase());

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (balance != user.balance) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        return role == user.role;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + balance;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", balance=" + balance +
                ", role=" + role +
                '}';
    }
}
