package by.bntu.coursework.dao;

public class SqlQuery {
    //User table
    public static final String FIND_ALL_USERS = "SELECT userId,login,password,name,surname,balance FROM users";
    public static final String FIND_BY_LOGIN = "SELECT userId,login,password,name,surname,balance FROM users WHERE login = ?";
    public static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT userId,login,password,name,surname,balance,roleName FROM users WHERE login = ? AND password = ?";
    public static final String ADD_USER = "INSERT INTO users(login, password, name, surname,balance,roleName) VALUES (?,?,?,?,?,?)";


    //Cat table
    public static final String FIND_ALL_CARS = "SELECT carId,title,price,description,status,color,mark FROM cars";
    public static final String FIND_CAR_BY_ID = "SELECT carId,title,price,description,status,color,mark FROM cars WHERE carId = ?";

    private SqlQuery() {

    }
}
