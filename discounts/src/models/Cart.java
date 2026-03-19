package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final List<Item> itemsOnCart;
    private Money money;

    public Cart(){
        itemsOnCart = new ArrayList<>();
        this.money = new Money(0, "MXN");
    }

    public Cart(List<Item> itemsOnCart, Money money) {
        this.itemsOnCart = itemsOnCart;
        this.money = money;
    }

    public List<Item> getItems() {
        return itemsOnCart;
    }

    public void addItem(Item item) {
        this.itemsOnCart.add(item);
        this.money = calculateAmount();
    }

    public void removeItem(Item item) {
        this.itemsOnCart.remove(item);
    }

    public Money calculateAmount() {
        Money amount = new Money(0, "MXN");
        for (Item item : itemsOnCart) {
            amount = amount.sumarMoney(item.calculateSubtotal());
        }
        return amount;
    }

    public Cart applyDiscount(Money descuento) {
        this.money = this.money.restarMoney(descuento);
        return this;
    }

    public Money getMoney() {
        return this.money;
    }
}
