/**
 * Money es un Value Object - representa dinero de forma segura.
 * INMUTABLE.
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

    //Getters de cantidad y tipo de moneda
     public int getAmount() {
        return amount;
    }
    
    public String getCurrency() {
        return currency;
    }

  

}
