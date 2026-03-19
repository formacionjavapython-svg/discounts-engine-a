import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Money getTotal() {
        Money total = new Money(0, "MXN");

        for (Item item : items) {
            total = total.add(item.getSubtotal());
        }

        return total;
    }
}