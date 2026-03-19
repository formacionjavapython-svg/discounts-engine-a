import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Money getTotal() {
        if (items.isEmpty()) {
            return new Money(0, "MXN");
        }

        Money total = new Money(0, "MXN");

        for (Item item : items) {
            total = total.add(item.getSubtotal());
        }

        return total;
    }

    public List<Item> getItems() {
        return items;
    }
}