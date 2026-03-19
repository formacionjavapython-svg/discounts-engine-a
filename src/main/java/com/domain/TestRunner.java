package com.domain;

import com.domain.discounts.BulkDiscount;
import com.domain.discounts.CouponDiscount;
import com.domain.discounts.ThresholdDiscount;
import com.domain.model.Cart;
import com.domain.model.Item;
import com.domain.model.Money;

public class TestRunner {

    static int passed = 0;
    static int failed = 0;

    static void assertEquals(String testName, double expected, double actual)
    {
        if (Math.abs(expected - actual) < 0.01)
        {
            System.out.println("  ✅ PASS: " + testName);
            passed++;
        }
        else
        {
            System.out.println("  ❌ FAIL: " + testName);
            System.out.println("      Esperado: " + expected + " | Obtenido: " + actual);
            failed++;
        }
    }

    static void testMoney()
    {
        System.out.println("\n[ Money ]");
        Money a = new Money(1000, "MXN");
        Money b = new Money(500, "MXN");
        assertEquals("add()",      1500, a.add(b).getAmount());
        assertEquals("subtract()", 500,  a.subtract(b).getAmount());
        assertEquals("multiply()", 100,  a.multiply(0.10).getAmount());

        try
        {
            new Money(-1, "MXN");
            System.out.println("  ❌ FAIL: Money negativo debería lanzar excepción");
            failed++;
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("  ✅ PASS: Money negativo lanza excepción");
            passed++;
        }
    }

    static void testCart()
    {
        System.out.println("\n[ Cart ]");
        Cart cart = new Cart();
        cart.addItem(new Item("Guitarra", new Money(4000, "MXN"), 1));
        cart.addItem(new Item("Bajo",     new Money(4000, "MXN"), 3));
        assertEquals("getTotal() = 16000", 16000, cart.getTotal().getAmount());
    }

    static void testThreshold()
    {
        System.out.println("\n[ ThresholdDiscount ]");
        Cart cartAlto = new Cart();
        cartAlto.addItem(new Item("Bajo", new Money(4000, "MXN"), 3));
        assertEquals("Total > 5000 → 10%", 1200, new ThresholdDiscount().apply(cartAlto).getAmount());

        Cart cartBajo = new Cart();
        cartBajo.addItem(new Item("Cable", new Money(100, "MXN"), 1));
        assertEquals("Total < 5000 → 0", 0, new ThresholdDiscount().apply(cartBajo).getAmount());
    }

    static void testBulk()
    {
        System.out.println("\n[ BulkDiscount ]");
        Cart cartBulk = new Cart();
        cartBulk.addItem(new Item("Bajo", new Money(4000, "MXN"), 3));
        assertEquals("quantity >= 3 → 5%", 600, new BulkDiscount().apply(cartBulk).getAmount());

        Cart cartPoco = new Cart();
        cartPoco.addItem(new Item("Guitarra", new Money(4000, "MXN"), 1));
        assertEquals("quantity < 3 → 0", 0, new BulkDiscount().apply(cartPoco).getAmount());
    }

    static void testCoupon()
    {
        System.out.println("\n[ CouponDiscount ]");
        Cart cart = new Cart();
        cart.addItem(new Item("Guitarra", new Money(4000, "MXN"), 1));
        double result = new CouponDiscount().apply(cart).getAmount();
        String secret = System.getenv("DISCOUNT_COUPON_SECRET");

        if (secret != null && secret.equals("CUPON2026")) {
            assertEquals("Cupón válido → 200", 200, result);
        } else {
            assertEquals("Sin cupón → 0", 0, result);
        }
    }

    public static void main(String[] args)
    {
        System.out.println("==============================");
        System.out.println("   Motor de Descuentos Tests  ");
        System.out.println("==============================");

        testMoney();
        testCart();
        testThreshold();
        testBulk();
        testCoupon();

        System.out.println("\n==============================");
        System.out.printf("  Resultado: %d✅  %d❌%n", passed, failed);
        System.out.println("==============================");

        if (failed > 0) System.exit(1);
    }
}