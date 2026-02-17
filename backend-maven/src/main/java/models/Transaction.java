package models;

// Imports.

import exceptions.InvalidValueException;

import java.io.Serial;
import java.io.Serializable;
//

public abstract class Transaction implements Serializable {
    @Serial
    private static final long serialVersionUID = 1l;

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

    @Override
    public String toString() {
        return "Transaction{" +
                "date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                '}';
    }
}
