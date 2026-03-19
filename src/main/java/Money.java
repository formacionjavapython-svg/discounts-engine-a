/**
 * Money es un Value Object - representa dinero de forma segura.
 */

public class Money {

    private final int amount;
    private final String currency;

    // Constructor - se valida que no haya valores negativos o nulos
    public Money(int amount, String currency) {
        if (amount < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo");
        }
        if (currency == null || currency.trim().isEmpty()) {
            throw new IllegalArgumentException("La moneda es requerida");
        }
        this.amount = amount;
        this.currency = currency;
    }

    // Getters de cantidad y tipo de moneda
    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public Money add(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("No se pueden sumar monedas diferentes");
        }
        return new Money(this.amount + other.amount, this.currency);
    }

    public Money subtract(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("No se pueden restar monedas diferentes");
        }
        if (this.amount < other.amount) {
            throw new IllegalArgumentException("El descuento no puede ser mayor al total");
        }
        return new Money(this.amount - other.amount, this.currency);
    }

}
