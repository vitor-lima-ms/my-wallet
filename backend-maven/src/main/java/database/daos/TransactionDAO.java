package database.daos;

// Imports.

import database.DBConnection;
import exceptions.InvalidValueException;
import models.Transaction;
import modules.expense.Expense;
import modules.income.Income;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
//

public class TransactionDAO {
    public void create(Transaction transaction) {
        String sql = "INSERT INTO transactions (date, description, type, value) VALUES (?, ?, ?, ?)";

        try (
                Connection connection = DBConnection.getConnection();

                PreparedStatement statement = connection.prepareStatement(sql);
                ) {
            statement.setString(1, transaction.getDate());

            statement.setString(2, transaction.getDescription());

            if (transaction instanceof Expense) {
                statement.setString(3, "expense");
            } else {
                statement.setString(3, "income");
            }

            statement.setDouble(4, transaction.getValue());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Transaction> findAll() {
        ArrayList<Transaction> transactions = new ArrayList<>();

        String sql = "SELECT * FROM transactions";

        try (
                Connection connection = DBConnection.getConnection();

                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);
                ) {
            while (resultSet.next()) {
                String transactionType = resultSet.getString("type");

                if (Objects.equals(transactionType, "expense")) {
                    transactions.add(new Expense(
                            resultSet.getString("date"),
                            resultSet.getString("description"),
                            resultSet.getDouble("value")
                    ));
                } else {
                    transactions.add(new Income(
                            resultSet.getString("date"),
                            resultSet.getString("description"),
                            resultSet.getDouble("value")
                    ));
                }
            }
        } catch (
                IllegalArgumentException | InvalidValueException | SQLException e
        ) {
            e.printStackTrace();
        }

        return transactions;
    }
}
