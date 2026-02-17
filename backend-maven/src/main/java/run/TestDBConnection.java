package run;

import database.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDBConnection {
    static void main(String[] args) {
        try (Connection connection = DBConnection.getConnection()) {
            if (connection != null) {
                System.out.println("DB connected.");
            }
        } catch (RuntimeException | SQLException e) {
            e.printStackTrace();
        }
    }
}
