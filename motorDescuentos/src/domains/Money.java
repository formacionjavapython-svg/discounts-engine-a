package domains;

public final class Money {
    private final double amount;
    private final String currency;

    public Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    // operaciones con dinero
    public Money add(Money other) {
        return new Money(this.amount + other.amount, this.currency);
    }
    public Money subtract(Money other) {
        return new Money(this.amount - other.amount, this.currency);
    }
    public Money multiply(int quantity) {
        return new Money(this.amount * quantity, this.currency);
    }

    // getters para usar en consola o para el ticket (de consulta)
    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}