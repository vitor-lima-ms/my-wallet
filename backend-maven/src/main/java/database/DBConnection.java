package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String PASSWORD = "ayfBU8cw";
    private static final String URL = "jdbc:postgresql://localhost:5431/postgres";
    private static final String USER = "postgres";

    public static Connection getConnection() throws RuntimeException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("DB connection error.", e);
        }
    }
}
