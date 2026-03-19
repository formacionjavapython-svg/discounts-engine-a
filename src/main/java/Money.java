public class Money {
    private final long amount;
    private final String currency;

    public Money(long amount, String currency) {
        if (currency == null || currency.isEmpty()) {
            throw new IllegalArgumentException("Currency inválida");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public long getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public Money add(Money other) {
        validateSameCurrency(other);
        return new Money(this.amount + other.amount, this.currency);
    }

    public Money multiply(int factor) {
        return new Money(this.amount * factor, this.currency);
    }

    private void validateSameCurrency(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Monedas diferentes");
        }
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}