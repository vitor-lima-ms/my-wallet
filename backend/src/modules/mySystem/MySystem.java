package modules.mySystem;

// Imports.
import exceptions.InvalidValueException;
import java.util.ArrayList;

import modules.expense.Expense;
import modules.fileManager.FileManager;
import modules.income.Income;
import models.Transaction;
//

public class MySystem {
    static void main(String[] args) {
        ArrayList<Transaction> transactions = FileManager.loadData();

        System.out.println(
                "Total de transações carregadas: " +
                transactions.size()
        );

        try {
            transactions.add(new Income(
                    "2026-02-06",
                    "Salario",
                    5000.00
            ));
        } catch (IllegalArgumentException | InvalidValueException e) {
            e.printStackTrace();
        }

        FileManager.saveData(transactions);

        FileManager.generateReport();
    }
}
