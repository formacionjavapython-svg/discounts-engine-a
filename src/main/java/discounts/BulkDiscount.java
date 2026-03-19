package discounts;

import classes.Cart;
import classes.Money;
import interfaz.DiscountRule;
import entity.Item;

/**
 * Regla que aplica un descuento porcentual si la cantidad total de productos
 * en el carrito supera un umbral mínimo.
 * Ejemplo: "15% de descuento si compras más de 10 artículos".
 */
public class BulkDiscount implements DiscountRule {
    private final int cantidadMinima;
    private final double porcentajeDescuento;

    public BulkDiscount(int cantidadMinima, double porcentajeDescuento) {
        this.cantidadMinima = cantidadMinima;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public Money aplicar(Cart cart) {
        // Sumamos todas las cantidades de los items en el carrito
        int totalArticulos = cart.getItems().stream()
                .mapToInt(Item::getCantidad)
                .sum();

        // Si cumple la condición, calculamos el porcentaje sobre el total bruto
        if (totalArticulos >= cantidadMinima) {
            return cart.calcularTotal().porciento(porcentajeDescuento);
        }

        // Si no cumple, el descuento es cero en la moneda del carrito
        return Money.of(0, cart.getCodigoMoneda());
    }
}
