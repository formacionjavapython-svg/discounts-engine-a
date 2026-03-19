import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("item no puede ser null");
        }
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public Money total() {
        if (items.isEmpty()) {
            return new Money(0, "MXN");
        }

        Money total = new Money(0, items.get(0).getPrice().getCurrency());

        for (Item item : items) {
            total = total.add(item.total());
        }

        return total;
    }
}