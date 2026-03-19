package modules.discounts.services;

import modules.discounts.dto.Money;
import modules.discounts.entity.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartService {

    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is required");
        }
        items.add(item);
    }

    public void removeItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is required");
        }
        items.remove(item);
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public Money total() {
        if (items.isEmpty()) {
            return Money.of(0, "MXN");
        }

        Money total = Money.of(0, items.get(0).getUnitPrice().getCurrency());

        for (Item item : items) {
            total = total.add(item.subtotal());
        }

        return total;
    }
}