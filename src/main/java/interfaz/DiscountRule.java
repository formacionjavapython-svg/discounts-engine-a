package interfaz;

import classes.Money;
import classes.Cart;
/**
 * Contrato para las estrategias de descuento.
 * Cada implementación decidirá su propia lógica basada en el contenido del carrito.
 */
@FunctionalInterface
public interface DiscountRule {
    /**
     * Calcula el monto a descontar basado en el estado del carrito.
     * @param carrito El carrito actual sobre el cual evaluar la regla.
     * @return Un objeto Dinero que representa el valor del descuento (ej: $50.00).
     */
    Money aplicar(Cart cart);
}
