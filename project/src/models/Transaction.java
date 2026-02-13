package models;

// Imports.
import exceptions.InvalidValueException;
//

public abstract class Transaction {
    private String date;
    private String description;
    private double value;

    // Construtor.
    public Transaction(
            String date,
            String description,
            double value
    ) throws IllegalArgumentException, InvalidValueException {
        if (description.isBlank()) {
            throw new IllegalArgumentException(
                    "A descrição deve ser enviada."
            );
        }

        if (value <= 0) {
            throw new InvalidValueException(
                    "O valor da transação deve ser maior que 0."
            );
        }

        this.date = date;
        this.description = description;
        this.value = value;
    }
    //

    // Getters e Setters.
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(
            String description
    ) throws IllegalArgumentException {
        if (description.isBlank()) {
            throw new IllegalArgumentException(
                    "A descrição deve ser enviada."
            );
        }

        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(
            double value
    ) throws InvalidValueException {
        if (value <= 0) {
            throw new InvalidValueException(
                    "O valor da transação deve ser maior que 0."
            );
        }

        this.value = value;
    }
    //

    public abstract void showDetails();
}
