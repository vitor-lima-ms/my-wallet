package modules.income;

// Imports.
import exceptions.InvalidValueException;
import models.Taxable;
import models.Transaction;
//

public class Income extends Transaction implements Taxable {
    // Construtor.
    public Income(
            String date,
            String description,
            double value
    ) throws IllegalArgumentException, InvalidValueException {
        super(date, description, value);
    }
    //

    public double calculateTax() {
        return 0.1 * this.getValue();
    }

    @Override
    public void showDetails() {
        System.out.println("******" + this.getDescription() + "******");
        System.out.println("Data: " + this.getDate());
        System.out.println("Valor: +" + this.getValue());
        System.out.println("Imposto: -" + this.calculateTax());
    }
}
