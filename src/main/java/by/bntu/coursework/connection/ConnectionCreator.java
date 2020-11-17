package by.bntu.coursework.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {
    private static final String SQL_URL = "jdbc:mysql://localhost:3306/coursebd?useUnicode=true&serverTimezone=UTC";
    private static final String SQL_USER = "root";
    private static final String SQL_PASSWORD = "Luki4_pups";
    private static final String SQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(SQL_DRIVER);
            connection = DriverManager.getConnection(SQL_URL,SQL_USER,SQL_PASSWORD);
        }catch (ClassNotFoundException| SQLException exp){
            throw new RuntimeException(exp);
        }
        return connection;
    }
}
