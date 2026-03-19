/*public class Main {
    public static void main(String[] args) {
        System.out.println("¡Hola, Mundo!");
    }
}*/

import domains.Money;
import domains.Cart;
import domains.Item;
import rules.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //  inicializamos el objeto carrito
        Cart cart = new Cart();

        // agregamos cada anrticulo al carrito con el comando addItem qie creamos en la calse Cart
        cart.addItem(new Item("Item 1", new Money(1000, "MXN"), 1));
        cart.addItem(new Item("Item 2", new Money(500, "MXN"), 2));

        // subtotal que creamos en la clase money
        Money subtotal = cart.calculateTotal();
        System.out.println("-----------------Recibo--------------------");
        System.out.println("Subtotal: " + subtotal);

        // inicalizamos la lista de descuentos posibles
        List<DiscountRule> rules = Arrays.asList(
                new Descuento10()
        );

// iniciamos en 0$ el descuento
        Money totalDiscountValue = new Money(0, "MXN");

// mapeamos
        for (DiscountRule rule : rules) {
            Money discountFound = rule.apply(cart);
            System.out.println("Aplicando regla... Descuento encontrado: " + discountFound);

// reducimos
            totalDiscountValue = totalDiscountValue.add(discountFound);
        }
        Money finalPrice = subtotal.subtract(totalDiscountValue);

        System.out.println("-----------------------");
        System.out.println("Descuento Total: " + totalDiscountValue); // Debería ser 1600.00 (el 10%)
        System.out.println("PRECIO FINAL A PAGAR: " + finalPrice);    // Debería ser 14400.00
    }
}