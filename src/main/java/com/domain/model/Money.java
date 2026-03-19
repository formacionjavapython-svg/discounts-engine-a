package com.domain.model;

/**
 * Guarda cantidad con: (amount)
 * Guarda moneda con: (currency)
 * Puede mezclar monedas
 */
public class Money
{
    private final double amount;
    private final String currency;

    public Money(double amount, String currency)
    {
        if(amount < 0) throw new IllegalArgumentException("Amount cannot be negative");
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount()
    {
        return amount;
    }

    //Suma
    public Money add(Money other)
    {
        return new Money(this.amount + other.amount, this.currency);
    }

    //Resta
    public Money subtract(Money other)
    {
        return new Money(this.amount - other.amount, this.currency);
    }

    @Override
    public String toString()
    {
        return amount + " " + currency;
    }
}
