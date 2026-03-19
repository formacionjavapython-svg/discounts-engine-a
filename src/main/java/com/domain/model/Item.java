package com.domain.model;

/**
 * Calcula precio * cantidad con la function getSubtotal
 */
public class Item
{
    private String name;
    private Money price;
    private int quantity;

    public Item(String name, Money price, int quantity)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Money getSubtotal()
    {
        return new Money(price.getAmount() * quantity, "MXN");
    }

    public int getQuantity()
    {
        return quantity;
    }
}
