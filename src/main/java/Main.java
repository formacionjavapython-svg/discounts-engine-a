import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        separador();

        probarCarritoSimple();
        separador();

        probarReglasDescuento();
        separador();

        probarSeguridadSecretos();
        separador();

        probarValidacionCupones();
    }

    // Método para mostrar separadores visuales
    private static void separador() {
        System.out.println("\n" + "=".repeat(80) + "\n");
    }

    // PRUEBA 1: Carrito simple con items
    private static void probarCarritoSimple() {
        System.out.println("=== Motor de Descuentos ===\n");

        Money precioLaptop = new Money(15000, "MXN");
        Money precioMouse = new Money(500, "MXN");
        Money precioTeclado = new Money(800, "MXN");

        Item laptop = new Item("Laptop Gamer", precioLaptop, 1);
        Item mouse = new Item("Mouse RGB", precioMouse, 1);
        Item mouse2 = new Item("Mouse RGB", precioMouse, 1);
        Item teclado = new Item("Teclado Mecanico", precioTeclado, 1);

        Cart cart = new Cart();
        cart.addItem(laptop);
        cart.addItem(mouse);
        cart.addItem(mouse2);
        cart.addItem(teclado);

        System.out.println("Productos en el carrito:");
        for (Item item : cart.getItems()) {
            System.out.println("  - " + item.getName() + " x" + item.getQuantity() +
                    " = $" + item.getSubtotal().getAmount() + " " + item.getSubtotal().getCurrency());
        }

        System.out.println("\nTotal del carrito: $" + cart.getTotal().getAmount() +
                " " + cart.getTotal().getCurrency());

        System.out.println("\n--- Removiendo el mouse ---");
        cart.removeItem(mouse);
        System.out.println("Items en carrito ahora: " + cart.getItemCount());
        System.out.println("Nuevo total: $" + cart.getTotal().getAmount() +
                " " + cart.getTotal().getCurrency());
    }

    // PRUEBA 2: Reglas de descuento
    private static void probarReglasDescuento() {
        System.out.println("=== Motor de Descuentos - Reglas de descuento ===\n");

        Cart cart = new Cart();
        cart.addItem(new Item("Laptop", new Money(15000, "MXN"), 1));
        cart.addItem(new Item("Mouse", new Money(500, "MXN"), 2));
        cart.addItem(new Item("Teclado", new Money(800, "MXN"), 1));

        System.out.println("Carrito original:");
        System.out.println(cart.getTotal().getAmount() + " " + cart.getTotal().getCurrency());

        List<DiscountRule> rules = Arrays.asList(
                new ThresholdDiscount(5000, 0.10),
                new CouponDiscount(200));

        System.out.println("\n=== Aplicando descuentos ===");

        Money descuentoTotal = new Money(0, "MXN");

        for (DiscountRule rule : rules) {
            Money descuento = rule.apply(cart);
            System.out.println("Regla: " + rule.getClass().getSimpleName() +
                    " - Descuento: $" + descuento.getAmount());
            descuentoTotal = descuentoTotal.add(descuento);
        }

        System.out.println("\n=== Resultados finales ===");
        System.out.println("Total original: $" + cart.getTotal().getAmount());
        System.out.println("Descuento total: $" + descuentoTotal.getAmount());

        Money totalFinal = cart.getTotal().subtract(descuentoTotal);
        System.out.println("Total a pagar: $" + totalFinal.getAmount());
    }

    // PRUEBA 3: Seguridad con secretos
    private static void probarSeguridadSecretos() {
        System.out.println("=== Motor de Descuentos - con seguridad y secretos ===\n");

        Cart cart = new Cart();
        cart.addItem(new Item("Laptop", new Money(15000, "MXN"), 1));
        cart.addItem(new Item("Mouse", new Money(500, "MXN"), 2));
        cart.addItem(new Item("Teclado", new Money(800, "MXN"), 1));

        System.out.println("Carrito original: $" + cart.getTotal().getAmount());

        List<DiscountRule> rules = Arrays.asList(
                new ThresholdDiscount(5000, 0.10),
                new CouponDiscount(200));

        Money descuentoTotal = new Money(0, "MXN");

        System.out.println("\n=== Aplicando descuentos ===");
        for (DiscountRule rule : rules) {
            Money descuento = rule.apply(cart);
            System.out.println(rule.getClass().getSimpleName() + ": $" + descuento.getAmount());
            descuentoTotal = descuentoTotal.add(descuento);
        }

        System.out.println("\n=== Resultados ===");
        System.out.println("Total original: $" + cart.getTotal().getAmount());
        System.out.println("Descuento total: $" + descuentoTotal.getAmount());

        Money totalFinal = cart.getTotal().subtract(descuentoTotal);
        System.out.println("Total a pagar: $" + totalFinal.getAmount());
    }

    // PRUEBA 4: Validación de cupones
    private static void probarValidacionCupones() {
        System.out.println("\n=== Probando validacion de cupones ===");

        Cart cart = new Cart();
        cart.addItem(new Item("Laptop", new Money(15000, "MXN"), 1));
        cart.addItem(new Item("Mouse", new Money(500, "MXN"), 2));
        cart.addItem(new Item("Teclado", new Money(800, "MXN"), 1));

        List<DiscountRule> rules = Arrays.asList(
                new ThresholdDiscount(5000, 0.10),
                new CouponDiscount(200));

        CouponDiscount cuponRule = (CouponDiscount) rules.get(1);

        // Probando con cupón incorrecto (en local prueba el correcto, en remoto solo el
        // incorrecto)
        String cuponIncorrecto = "OTRO2024";
        boolean resultado = cuponRule.validarCupon(cuponIncorrecto);
        System.out.println("Cupon '" + cuponIncorrecto + "' = " + resultado);
    }
}