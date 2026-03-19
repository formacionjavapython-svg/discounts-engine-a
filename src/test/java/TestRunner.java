package test.java;

import main.java.Cart;
import main.java.CouponDiscount;
import main.java.Item;
import main.java.ThresholdDiscount;

public class TestRunner {
    public static void main(String[] args) {
        System.out.println("*** Iniciando Pruebas Unitarias Manuales ***");

        testCartSubtotal();// 1
        testThresholdDiscount();// 2
        testInvalidCoupon();// 3
        testBulkDiscount();
        System.out.println("*** Pruebas Finalizadas ***");
    }

    // CASO 1
    public static void testCartSubtotal() {
        Cart cart = new Cart();
        cart.addItem(new Item("Laptop", 1000.0, 2)); // 2000
        cart.addItem(new Item("Mouse", 500.0, 1)); // 500

        double expected = 2500.0;
        if (Math.abs(cart.getTotal() - expected) < 0.001) {
            System.out.println("[CORRECTO] testCartSubtotal");
        } else {
            System.out.println("[FALLA] testCartSubtotal. Esperado: " + expected + ", Obtenido: " + cart.getTotal());
        }
    }

    // CASO 2
    public static void testThresholdDiscount() {

        Cart cart = new Cart();
        cart.addItem(new Item("Test Product", 6000.0, 1));

        ThresholdDiscount rule = new ThresholdDiscount(5000.0, 0.10);
        double result = rule.apply(cart);
        double expected = 600.0;

        if (Math.abs(result - expected) < 0.001) {
            System.out.println("[CORRECTO] testThresholdDiscount");
        } else {
            System.out.println("[FALLA] testThresholdDiscount. Esperado: " + expected + ", Obtenido: " + result);
        }
    }

    // CASO 3
    public static void testInvalidCoupon() {
        Cart cart = new Cart();
        cart.addItem(new Item("Teclado", 1000.0, 1));

        // Simulamos que el usuario pone un cupón que NO existe
        CouponDiscount rule = new CouponDiscount("CUPON_FALSO", 100.0);
        double result = rule.apply(cart);
        double expected = 0.0;

        if (result == expected) {
            System.out.println("[CORRECTO] testInvalidCoupon (Descuento 0)");
        } else {
            System.out.println("[FALLA] testInvalidCoupon. No debería aplicar descuento.");
        }
    }

    public static void testBulkDiscount() {
        Cart cart = new Cart();
        // 5 mouses de $100 = $500. Regla: 3+ unidades dan 5% de descuento.
        cart.addItem(new Item("Mouse", 100.0, 5));

        main.java.BulkDiscount rule = new main.java.BulkDiscount(3, 0.05);
        double result = rule.apply(cart);
        double expected = 25.0; // 500 * 0.05

        if (Math.abs(result - expected) < 0.001) {
            System.out.println("[CORRECTO] testBulkDiscount");
        } else {
            System.out.println("[FALLA] testBulkDiscount. Esperado: " + expected + ", Obtenido: " + result);
        }
    }
}
