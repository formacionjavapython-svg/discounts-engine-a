package test;

    import objetosDescuento.*;

    public class TestRunner {
        public static void main(String[] args) {
            int passed = 0;
            int failed = 0;

            // Caso 1: Subtotal
            if (testSubtotal()) { passed++; } else { failed++; }

            // Caso 2: Descuento Threshold
            if (testThresholdDiscount()) { passed++; } else { failed++; }

            // Caso 3: Cupón Inválido
            if (testInvalidCoupon()) { passed++; } else { failed++; }

            System.out.println("\n--- REPORTE DE TESTS ---");
            System.out.println("Pasados: " + passed);
            System.out.println("Fallidos: " + failed);
        }

        // Caso 1: Verifica precio * cantidad
        static boolean testSubtotal() {
            Cart cart = new Cart();
            cart.addItem(new Item("Ram", new Money(1000, "MXN"), 2));
            boolean result = cart.calculateTotal().getAmount() == 2000.0;
            System.out.println("Test Subtotal: " + (result ? "PASSED" : "FAILED"));
            return result;
        }

        // Caso 2: Verifica el 10% si > 5000
        static boolean testThresholdDiscount() {
            Cart cart = new Cart();
            cart.addItem(new Item("GPU", new Money(6000, "MXN"), 1));
            ThresholdDiscount rule = new ThresholdDiscount();
            boolean result = rule.apply(cart).getAmount() == 600.0;
            System.out.println("Test Threshold: " + (result ? "PASSED" : "FAILED"));
            return result;
        }

        // Caso 3: Verifica que cupón incorrecto dé 0
        static boolean testInvalidCoupon() {
            Cart cart = new Cart();
            // Simulamos que la variable de entorno NO coincide (o es nula)
            CouponDiscount rule = new CouponDiscount();
            boolean result = rule.apply(cart).getAmount() == 0.0;
            System.out.println("Test Cupón Inválido: " + (result ? "PASSED" : "FAILED"));
            return result;
        }
    }

