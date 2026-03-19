import modules.discounts.dto.Money;
import modules.discounts.entity.Item;
import modules.discounts.interfaces.DiscountRule;
import modules.discounts.services.BulkDiscount;
import modules.discounts.services.CartService;
import modules.discounts.services.CouponDiscount;
import modules.discounts.services.ThresholdDiscount;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        runTests();

        CartService cart = new CartService();

        cart.addItem(new Item("Laptop", Money.of(15000, "MXN"), 1));
        cart.addItem(new Item("Mouse", Money.of(500, "MXN"), 3));

        System.out.println("Total carrito: " + cart.total());

        List<DiscountRule> rules = List.of(
                new ThresholdDiscount(Money.of(5000, "MXN"), 0.10),
                new CouponDiscount("SUPER2024", Money.of(500, "MXN")),
                new BulkDiscount(3, 0.05)
        );

        Money totalDiscount = Money.zero(cart.total().getCurrency());

        for (DiscountRule rule : rules) {
            totalDiscount = totalDiscount.add(rule.apply(cart));
        }

        Money cartTotal = cart.total();

        if (totalDiscount.getAmount().compareTo(cartTotal.getAmount()) > 0) {
            totalDiscount = cartTotal;
        }

        Money finalTotal = cartTotal.subtract(totalDiscount);

        System.out.println("Descuento total: " + totalDiscount);
        System.out.println("Total final: " + finalTotal);
    }


    static void runTests() {
        int passed = 0;
        int failed = 0;

        System.out.println("\n=== RUNNING TESTS ===");

        if (testSubtotal()) passed++; else failed++;
        if (testThresholdDiscount()) passed++; else failed++;
        if (testInvalidCoupon()) passed++; else failed++;

        System.out.println("\n=== RESULT ===");
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
    }


    static boolean testSubtotal() {
        try {
            CartService cart = new CartService();
            cart.addItem(new Item("Laptop", Money.of(15000, "MXN"), 1));
            cart.addItem(new Item("Mouse", Money.of(500, "MXN"), 2));

            Money result = cart.total();
            Money expected = Money.of(16000, "MXN");

            assertEquals(expected, result, "Subtotal calculation failed");

            System.out.println("✔ testSubtotal");
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    static boolean testThresholdDiscount() {
        try {
            CartService cart = new CartService();
            cart.addItem(new Item("Laptop", Money.of(15000, "MXN"), 1));

            DiscountRule rule = new ThresholdDiscount(Money.of(5000, "MXN"), 0.10);

            Money result = rule.apply(cart);
            Money expected = Money.of(1500, "MXN");

            assertEquals(expected, result, "Threshold discount failed");

            System.out.println("✔ testThresholdDiscount");
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    static boolean testInvalidCoupon() {
        try {
            CartService cart = new CartService();
            cart.addItem(new Item("Laptop", Money.of(15000, "MXN"), 1));

            DiscountRule rule = new CouponDiscount("WRONG", Money.of(500, "MXN"));

            Money result = rule.apply(cart);
            Money expected = Money.zero("MXN");

            assertEquals(expected, result, "Invalid coupon should return zero");

            System.out.println("✔ testInvalidCoupon");
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    // Método helper
    static void assertEquals(Money expected, Money actual, String message) {
        if (!expected.equals(actual)) {
            throw new RuntimeException(
                    "❌ " + message + " | expected: " + expected + ", actual: " + actual
            );
        }
    }
}