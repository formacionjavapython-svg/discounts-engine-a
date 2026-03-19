package main.java;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        // Escenario: 1 Laptop cara y 5 Mouse (para activar Bulk y Threshold)
        cart.addItem(new Item("Laptop Pro", 20000.0, 1)); 
        cart.addItem(new Item("Mouse Optico", 200.0, 5)); // 5 unidades activa BulkDiscount

        List<DiscountRule> rules = Arrays.asList(
            new ThresholdDiscount(5000, 0.10), // 10% por compra > 5000
            new CouponDiscount(),              // Descuento fijo de cupón
            new BulkDiscount(3, 0.05)          // 5% en productos con 3+ unidades
        );

        double subtotal = cart.getTotal();
        double totalDiscount = 0;

        for (DiscountRule rule : rules) {
            totalDiscount += rule.apply(cart);
        }

        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Total Descuentos: $" + totalDiscount);
        System.out.println("Total a Pagar: $" + (subtotal - totalDiscount));
    }
}