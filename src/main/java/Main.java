import model.Cart;
import model.Item;
import model.Money;
import service.impl.CouponIDiscount;
import service.IDiscountRule;
import service.impl.ThresholdIDiscount;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // se crea el carrito
        Cart cart = new Cart("SUPER2024"); // se crea un carrito agregando un cupon de descuento

        // se crean articulos y se añaden al carrito
        cart.addItem(new Item("Laptop", new Money(new BigDecimal("15000.00"), "MXN"), 1));
        cart.addItem(new Item("Mouse", new Money(new BigDecimal("500.00"), "MXN"), 2));

        // se verifica el total antes de descuento
        Money totalBeforeDiscount = cart.calculateTotal();
        System.out.println("Total antes de descuentos: " + totalBeforeDiscount.amount() + " " + totalBeforeDiscount.currency());

        List<IDiscountRule> rules = Arrays.asList(
                new ThresholdIDiscount(), // Descuento si supera 5000
                new CouponIDiscount()      // Descuento de cupón fijo
        );

        // verificamos el total del descuento
        Money totalDiscount = rules.stream()
                .map(rule -> rule.apply(cart)) // Aquí aplicamos cada regla al carrito
                .reduce(new Money(BigDecimal.ZERO, "MXN"), Money::add);

        // se obtiene el total de descuento
        System.out.println("Total de descuentos aplicados: " + totalDiscount.amount());

        // se resta el total del descuento
        BigDecimal finalAmount = totalBeforeDiscount.amount().subtract(totalDiscount.amount());
        System.out.println("TOTAL A PAGAR: " + finalAmount + " MXN");
    }
}