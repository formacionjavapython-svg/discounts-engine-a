package domain.model;

import java.util.Objects;

public class Money {
    private final double amount;
    private final String currency;

    public Money(double amount, String currency) {
        if (amount < 0) throw new IllegalArgumentException("El monto no puede ser negativo");
        this.amount = amount;
        this.currency = Objects.requireNonNull(currency);
    }

    public Money add(Money other) {
        checkCurrency(other);
        return new Money(this.amount + other.amount, this.currency);
    }

    public Money multiply(int quantity) {
        return new Money(this.amount * quantity, this.currency);
    }

    public Money subtract(Money other) {
        checkCurrency(other);
        return new Money(Math.max(0, this.amount - other.amount), this.currency);
    }

    private void checkCurrency(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("No se pueden operar monedas distintas");
        }
    }

    public double getAmount() { return amount; }
    public String getCurrency() { return currency; }

    @Override
    public String toString() { return amount + " " + currency; }
}
