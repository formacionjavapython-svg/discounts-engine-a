package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Item> itemsOnCart;

    public Cart(){
        itemsOnCart = new ArrayList<>();
    }

    public List<Item> getItems() {
        return itemsOnCart;
    }

    public void addItem(Item item) {
        this.itemsOnCart.add(item);
    }

    public void removeItem(Item item) {
        this.itemsOnCart.remove(item);
    }

    public float calculateAmount() {
        float amount = 0;
        for (Item item : itemsOnCart) {
            amount += item.calculateSubtotal();
        }
        return amount;
    }
}
