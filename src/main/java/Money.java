

public final class Money {
    private double amount;
    private String currency;

    public Money(double amount, String currency) {
        if (amount <= 0) {
            this.amount = 0; // correccion a 0
        }
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() { return amount; }
    public String getCurrency() { return currency; }

    
}
