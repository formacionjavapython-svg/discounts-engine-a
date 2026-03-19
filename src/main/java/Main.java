import java.util.Arrays;
import java.util.List;

import domain.model.Cart;
import domain.model.Item;
import domain.model.Money;
import domain.service.discount.CouponDiscount;
import domain.service.discount.DiscountRule;
import domain.service.discount.ThresholdDiscount;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Cart miCarrito = new Cart("MXN");
        miCarrito.addItem(new Item("Laptop", new Money(15000, "MXN"), 1));
        miCarrito.addItem(new Item("Mause", new Money(500, "MXN"), 2));

        Money subtotal = miCarrito.calculateSubtotal();
        System.out.println("Total sin descuento: $" + subtotal);

        List<DiscountRule> rules = Arrays.asList(
            new ThresholdDiscount(5000, 0.10), // aplica 10% si es mayor a 5000
            new CouponDiscount(new Money(200, "MXN")) // este es un ejemplo de cupon que descuenta $200
        );

        Money totalDiscount = new Money(0, "MXN");
        for (DiscountRule rule : rules) {
            totalDiscount = totalDiscount.add(rule.apply(miCarrito));
        }

        Money finalTotal = subtotal.subtract(totalDiscount);

        System.out.println("Subtotal: " + subtotal);
        System.out.println("Total Descuentos: " + totalDiscount);
        System.out.println("Total a Pagar: " + finalTotal);
    }
}
