package modules.system;

// Imports.
import java.util.ArrayList;
import models.Transaction;
import modules.expense.Expense;
import modules.income.Income;
//

public class System {
    static void main(String[] args) {
        // Criando lista de transações.
        ArrayList<Transaction> transactionsList = new ArrayList<Transaction>();
        //

        // Instanciando transações e as adicionando à lista.
        Transaction income01 = new Income(
                "2025-02-06",
                "Salário",
                5000.00
        );
        transactionsList.add(income01);

        Transaction expense01 = new Expense(
                "2025-02-10",
                "Mensalidade Mackenzie",
                567.00
        );
        transactionsList.add(expense01);

        Transaction expense02 = new Expense(
                "2025-02-06",
                "Mensalidade Psicóloga",
                180.00
        );
        transactionsList.add(expense02);
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
