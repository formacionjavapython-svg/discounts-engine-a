package domain.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Item> items = new ArrayList<>();
    private final String currency;

    public Cart(String currency) {
        this.currency = currency;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public Money calculateSubtotal() {
        Money total = new Money(0, currency);
        for (Item item : items) {
            total = total.add(item.getSubtotal());
        }
        return total;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items); // Retorna una copia para asi proteger el stado
    }
}
