package domains;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        this.items.add(item);
    }

    public Money calculateTotal() {
        // calculamos el total (subtotal) del carrito pero primero inicializamos en 0, no le cobraré al cliente sólo por entrar
        Money total = new Money(0, "MXN");
        //sumador de tiems en el carrito
        for (Item item : items) {
            total = total.add(item.getSubtotal());
        }

        return total;
    }

    // getter para descuentos
    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Carrito: " + items.size() + " productos. Total: " + calculateTotal();
    }
}