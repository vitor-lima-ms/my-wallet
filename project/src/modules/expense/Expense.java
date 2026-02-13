package modules.expense;

// Imports.
import models.Transaction;
//

public class Expense extends Transaction {
    // Construtor.
    public Expense(
            String date,
            String description,
            double value
    ) {
        super(date, description, value);
    }
    //

    @Override
    public void showDetails() {
        System.out.println("******" + this.getDescription() + "******");
        System.out.println("Data: " + this.getDate());
        System.out.println("Valor: -" + this.getValue());
    }
}
