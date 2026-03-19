/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio;

/**
 *
 * @author sam87
 */
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public Money calculateTotal() {
        Money total = new Money(0, "MXN");
        for (Item item : items) {
            total = total.add(item.getSubtotal());
        }
        return total;
    }
}
