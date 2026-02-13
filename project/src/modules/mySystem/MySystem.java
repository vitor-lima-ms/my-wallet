package modules.mySystem;

// Imports.
import java.util.ArrayList;

import exceptions.InvalidValueException;
import models.Transaction;
import modules.expense.Expense;
import modules.income.Income;
//

public class MySystem {
    static void main(String[] args) {
        // Criando lista de transações.
        ArrayList<Transaction> transactionsList = new ArrayList<>();
        //

        // Válida.
        try {
            Transaction income01 = new Income(
                    "2025-02-06",
                    "Salário",
                    5000.00
            );
            transactionsList.add(income01);
        } catch (IllegalArgumentException | InvalidValueException e) {
            System.out.println(e.getMessage());;
        }
        //

        // Inválida.
        try {
            Transaction expense02 = new Expense(
                    "2025-02-06",
                    "Mensalidade Psicóloga",
                    -180.00
            );
            transactionsList.add(expense02);
        } catch (IllegalArgumentException | InvalidValueException e) {
            System.out.println(e.getMessage());
        }
        //

        // Exibindo os detalhes.
        for (
                int i = 0;
                i < transactionsList.size();
                i++
        ) {
            Transaction transaction = transactionsList.get(i);

            transaction.showDetails();
        }
        //
    }
}
