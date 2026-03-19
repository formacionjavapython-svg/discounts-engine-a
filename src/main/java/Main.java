import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Carrito
        Cart cart = new Cart();

        // Productos
        cart.addItem(new Item("Laptop", new Money(6000, "MXN"), 1));
        cart.addItem(new Item("Mouse", new Money(500, "MXN"), 2));

        // Total
        System.out.println("Total: " + cart.getTotal().getAmount());

        // Reglas
        List<DiscountRule> rules = Arrays.asList(
            new ThresholdDiscount(5000, 0.10),
            new CouponDiscount()
        );

        // ApliReglas
        Money totalDiscount = new Money(0, "MXN");

        for (DiscountRule rule : rules) {
            totalDiscount = totalDiscount.add(rule.apply(cart));
        }

        // Descuento
        System.out.println("Descuento total: " + totalDiscount.getAmount());
    }
}