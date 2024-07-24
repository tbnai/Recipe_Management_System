package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/recipedb";
    private static final String USER = "root";
    private static final String PASSWORD = "root123.";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
