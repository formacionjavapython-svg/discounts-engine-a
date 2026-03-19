package main.java;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public List<Item> getItems() {
        return new ArrayList<>(items); 
    }

    public double getTotal() {
        return items.stream()
                .mapToDouble(Item::getSubtotal)
                .sum();
    }
}