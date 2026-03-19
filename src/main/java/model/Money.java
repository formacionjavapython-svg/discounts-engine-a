package model;

import java.math.BigDecimal;

// record inmutable que representa al dinero en la aplicación, tiene una cantidad y una moneda.
public record Money(BigDecimal amount, String currency) {

    public Money add(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currencies must match");
        }
        return new Money(this.amount.add(other.amount), this.currency);
    }
}