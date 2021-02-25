package by.bntu.coursework.dao;

public class SqlQuery {
    //User table
    public static final String FIND_ALL_USERS = "SELECT userId,login,password,name,surname,balance FROM users";
    public static final String FIND_BY_LOGIN = "SELECT userId,login,password,name,surname,balance FROM users WHERE login = ?";
    public static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT userId,login,password,name,surname,balance,roleName FROM users WHERE login = ? AND password = ?";
    public static final String ADD_USER = "INSERT INTO users(login, password, name, surname,balance,roleName) VALUES (?,?,?,?,?,?)";
    public static final String CHECK_UNIQUE_LOGIN = "SELECT login FROM users WHERE login = ?";

    //Car table
    public static final String ADD_CAR = "INSERT INTO cars(mark, title, color, description, price, status) VALUES (?,?,?,?,?,true)";
    public static final String FIND_ALL_CARS = "SELECT carId,title,price,description,status,color,mark FROM cars";
    public static final String FIND_ACTIVE_CARS = "SELECT carId,title,price,description,status,color,mark FROM cars WHERE status = true";
    public static final String FIND_CAR_BY_ID = "SELECT carId,title,price,description,status,color,mark FROM cars WHERE carId = ?";
    public static final String BAN_CAR_BY_ID = "UPDATE cars SET status = false WHERE carId = ?";
    public static final String UNBAN_CAR_BY_ID = "UPDATE cars SET status = true WHERE carId = ?";
    private SqlQuery() {

    }
}
