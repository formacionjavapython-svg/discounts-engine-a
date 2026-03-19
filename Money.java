/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio;

/**
 *
 * @author sam87
 */

    public record Money(double amount, String currency) {
    public Money {
        if (amount < 0) throw new IllegalArgumentException("El monto no puede ser negativo");
    }

    public Money add(Money other) {
        return new Money(this.amount + other.amount, this.currency);
    }
    
    public Money multiply(double factor) {
        return new Money(this.amount * factor, this.currency);
    }
}

