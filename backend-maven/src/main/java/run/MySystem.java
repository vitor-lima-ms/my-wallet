package run;

// Imports.

import database.daos.TransactionDAO;
import exceptions.InvalidValueException;
import models.Transaction;
import modules.expense.Expense;
import modules.income.Income;

import java.util.ArrayList;
//

public class MySystem {
    static void main(String[] args) {
        TransactionDAO transactionDAO = new TransactionDAO();

        try {
            transactionDAO.create(new Income(
                    "2026-02-06",
                    "Salário",
                    5000.00
            ));
        } catch (IllegalArgumentException | InvalidValueException e) {
            e.printStackTrace();
        }

        try {
            transactionDAO.create(new Expense(
                    "2026-02-06",
                    "Mensalidade Psicóloga",
                    180.00
            ));
        } catch (IllegalArgumentException | InvalidValueException e) {
            e.printStackTrace();
        }

        try {
            transactionDAO.create(new Expense(
                    "2026-02-10",
                    "Mensalidade Mackenzie",
                    567.00
            ));
        } catch (IllegalArgumentException | InvalidValueException e) {
            e.printStackTrace();
        }

        ArrayList<Transaction> transactions = transactionDAO.findAll();

        for (
                int i = 0;
                i < transactions.size();
                i++
        ) {
           transactions.get(i).showDetails();
        }
    }
}
