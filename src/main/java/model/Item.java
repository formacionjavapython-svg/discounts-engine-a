package model;

import java.math.BigDecimal;

// Clase que representa los articulos del carrito
public class Item {

    private String name;
    private Money price;
    private int quantity;

    public Item(String name, Money price, int quantity) {
        this.name = name;
        this.price = price;
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        } else {
            this.quantity = quantity;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // metodo que sirve para regresar un subtotal por cada articulo
    public Money calculateSubtotal() {
        BigDecimal subtotal = this.price.amount().multiply(new BigDecimal(this.quantity));
        return new Money(subtotal, this.price.currency());
    }
}