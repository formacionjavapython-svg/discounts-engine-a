public final class Money {
    private final int amount;
    private final String currency;

    public Money(int amount, String currency) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount no puede ser negativo");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("currency es obligatoria");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
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
        if (factor < 0) {
            throw new IllegalArgumentException("factor no puede ser negativo");
        }
        return new Money(this.amount * factor, this.currency);
    }

    private void validateSameCurrency(Money other) {
        if (other == null) {
            throw new IllegalArgumentException("other no puede ser null");
        }
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("las monedas no coinciden");
        }
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}