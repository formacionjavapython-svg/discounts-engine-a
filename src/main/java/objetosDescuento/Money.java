package objetosDescuento;
public class Money {

    private double amount;
    private String currency;

    //Constructor completo
    public Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
    //Constructor simple
    public Money(double amount) {
        this.amount = amount;
    }
    public double getAmount() {
        return amount;
    }
    public String getCurrency() {
        return currency;
    }
    public Money multiply(int multiplicator){
        double newAmount = this.amount * multiplicator;
        return new Money(newAmount, this.currency);
    }
    public Money sumar(Money otroMonto){
        return new Money(this.amount + otroMonto.getAmount(), this.currency);

    }
}