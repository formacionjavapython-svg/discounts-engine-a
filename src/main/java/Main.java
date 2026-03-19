import domain.model.Cart;
import domain.model.Item;
import domain.model.Money;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Cart miCarrito = new Cart("MXN");
        miCarrito.addItem(new Item("Laptop", new Money(15000, "MXN"), 1));
        miCarrito.addItem(new Item("Mause", new Money(500, "MXN"), 2));

        System.out.println("Total sin descuento: $" + miCarrito.calculateSubtotal());
    }
}
