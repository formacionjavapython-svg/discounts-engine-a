import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public Money calculateTotal() {
        if (items.isEmpty()) {
            return new Money(0, "MXN");
        }

        Money total = items.get(0).getSubtotal();
        for (int i = 1; i < items.size(); i++) {
            total = total.add(items.get(i).getSubtotal());
        }
        return total;
    }
}