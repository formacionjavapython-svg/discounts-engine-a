import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.addItem(new Item("Laptop Gamer", new Money(15000, "MXN"), 1));
        cart.addItem(new Item("Mouse Inalambrico", new Money(500, "MXN"), 2));

        System.out.println("--- MOTOR DE DESCUENTOS ---");
        System.out.println("Total sin descuentos: " + cart.calculateTotal());

        List<DiscountRule> rules = Arrays.asList(
                new ThresholdDiscount(5000, 0.10, "MXN"),
                new CouponDiscount("SUPER2024", 0.20)
        );

        Money totalDiscount = new Money(0, "MXN");
        for (DiscountRule rule : rules) {
            Money currentDiscount = rule.apply(cart);
            totalDiscount = totalDiscount.add(currentDiscount);
            System.out.println("Descuento aplicado por regla: " + currentDiscount);
        }

        System.out.println("Descuento total: " + totalDiscount);
        System.out.println("Total a pagar: " + cart.calculateTotal().subtract(totalDiscount));
    }
}