import model.Cart;
import model.Item;
import model.Money;
import service.impl.CouponIDiscount;
import service.impl.ThresholdIDiscount;

import java.math.BigDecimal;

public class TestRunner {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO PRUEBAS UNITARIAS (CUSTOM) ===");
        int passed = 0;
        int failed = 0;

        // Caso 1: Verificar Subtotal
        try {
            testCalculateTotal();
            System.out.println("Test 1: Cálculo de Subtotal - PASADO");
            passed++;
        } catch (Exception e) {
            System.err.println("Test 1: Cálculo de Subtotal - FALLIDO: " + e.getMessage());
            failed++;
        }

        // Caso 2: Verificar Descuento
        try {
            testThresholdDiscount();
            System.out.println("Test 2: Descuento por Umbral (10%) - PASADO");
            passed++;
        } catch (Exception e) {
            System.err.println("Test 2: Descuento por Umbral - FALLIDO: " + e.getMessage());
            failed++;
        }

        // Caso 3: Verificar Cupón Inválido
        try {
            testInvalidCoupon();
            System.out.println("Test 3: Validación de Cupón Inválido - PASADO");
            passed++;
        } catch (Exception e) {
            System.err.println("Test 3: Cupón Inválido - FALLIDO: " + e.getMessage());
            failed++;
        }

        System.out.println("RESULTADOS FINALES:");
        System.out.println("Pruebas exitosas: " + passed);
        System.out.println("Pruebas fallidas: " + failed);

        if (failed > 0) {
            System.exit(1); // Salir con error si algo falló
        }
    }

    // Caso 1
    private static void testCalculateTotal() throws Exception {
        Cart cart = new Cart();
        cart.addItem(new Item("Producto A", new Money(new BigDecimal("100.00"), "MXN"), 2));
        cart.addItem(new Item("Producto B", new Money(new BigDecimal("50.00"), "MXN"), 1));

        BigDecimal expected = new BigDecimal("250.00");
        BigDecimal actual = cart.calculateTotal().amount();

        if (actual.compareTo(expected) != 0) {
            throw new Exception("Se esperaba 250.00 pero se obtuvo " + actual);
        }
    }

    // Caso 2
    private static void testThresholdDiscount() throws Exception {
        Cart cart = new Cart();
        cart.addItem(new Item("Laptop Pro", new Money(new BigDecimal("10000.00"), "MXN"), 1));

        ThresholdIDiscount rule = new ThresholdIDiscount();
        BigDecimal discount = rule.apply(cart).amount();
        BigDecimal expected = new BigDecimal("1000.00");

        if (discount.compareTo(expected) != 0) {
            throw new Exception("Descuento incorrecto. Se esperaba " + expected + " pero fue " + discount);
        }
    }

    // Caso 3
    private static void testInvalidCoupon() throws Exception {
        Cart cart = new Cart("CUPON_ERRONEO");
        CouponIDiscount rule = new CouponIDiscount();

        BigDecimal discount = rule.apply(cart).amount();

        if (discount.compareTo(BigDecimal.ZERO) != 0) {
            throw new Exception("Error: Se aplicó un descuento con un cupón inválido.");
        }
    }

}
