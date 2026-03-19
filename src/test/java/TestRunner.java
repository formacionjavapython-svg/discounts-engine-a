/**
 * TestRunner para el Motor de Descuentos.
 */
public class TestRunner {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        System.out.println("=== MOTOR DE DESCUENTOS - TEST SUITE ===");
        System.out.println();

        runTest("Caso 1: Cart calcula subtotal correctamente",
            TestRunner::testCartSubtotal);

        runTest("Caso 2: ThresholdDiscount aplica 10% sobre $5000",
            TestRunner::testThresholdDiscount);

        runTest("Caso 3: CouponDiscount retorna $0 con cupon invalido",
            TestRunner::testInvalidCoupon);

        System.out.println();
        System.out.println("========================================");
        System.out.println("  RESULTADOS: " + passed + " passed, "
            + failed + " failed, " + (passed + failed) + " total");
        System.out.println("========================================");

        if (failed > 0) {
            System.exit(1);
        }
    }

    private static boolean testCartSubtotal() {
        Cart cart = new Cart();
        cart.addItem(new Item("Laptop", new Money(15000, "MXN"), 1));
        cart.addItem(new Item("Mouse", new Money(500, "MXN"), 2));

        Money expected = new Money(16000, "MXN");
        Money actual = cart.calculateTotal();

        return assertEqual(expected, actual,
            "Subtotal esperado: " + expected
            + ", obtenido: " + actual);
    }

    private static boolean testThresholdDiscount() {
        Cart cart = new Cart();
        cart.addItem(new Item("Laptop", new Money(10000, "MXN"), 1));

        ThresholdDiscount rule =
            new ThresholdDiscount(5000, 0.10, "MXN");
        Money discount = rule.apply(cart);

        Money expected = new Money(1000, "MXN");

        return assertEqual(expected, discount,
            "Descuento esperado: " + expected
            + ", obtenido: " + discount);
    }

    private static boolean testInvalidCoupon() {
        Cart cart = new Cart();
        cart.addItem(new Item("Teclado", new Money(2000, "MXN"), 1));

        CouponDiscount rule =
            new CouponDiscount("CUPON_FALSO", 0.20);
        Money discount = rule.apply(cart);

        Money expected = new Money(0, "MXN");

        return assertEqual(expected, discount,
            "Descuento esperado: " + expected
            + ", obtenido: " + discount);
    }


    private static void runTest(String name, TestCase test) {
        try {
            boolean result = test.execute();
            if (result) {
                System.out.println("  PASS: " + name);
                passed++;
            } else {
                System.out.println("  FAIL: " + name);
                failed++;
            }
        } catch (Exception e) {
            System.out.println("  ERROR: " + name
                + " -> " + e.getMessage());
            failed++;
        }
    }

    private static boolean assertEqual(
            Money expected, Money actual, String msg) {
        boolean result = expected.getAmount()
            .compareTo(actual.getAmount()) == 0;
        if (!result) {
            System.out.println("    -> " + msg);
        }
        return result;
    }

    @FunctionalInterface
    interface TestCase {
        boolean execute();
    }
}
