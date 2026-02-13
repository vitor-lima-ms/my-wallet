package models;

public abstract class Transaction {
    private String date;
    private String description;
    private double value;

    // Construtor.
    public Transaction(
            String date,
            String description,
            double value
    ) {
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

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    //

    public abstract void showDetails();
}
