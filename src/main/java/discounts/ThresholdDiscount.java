package discounts;

import classes.Cart;
import classes.Money;
import interfaz.DiscountRule;

/**
 * Regla que aplica un descuento si el total bruto del carrito 
 * alcanza o supera un monto mínimo (Umbral).
 */
public class ThresholdDiscount implements DiscountRule {
    private final Money umbralMinimo;
    private final DiscountRule descuentoAplicable;

    /**
     * @param umbralMinimo El monto necesario para activar la regla (ej: $1000).
     * @param descuentoAplicable La regla que se ejecutará si se supera el umbral.
     */
    public ThresholdDiscount(Money umbralMinimo, DiscountRule descuentoAplicable) {
        this.umbralMinimo = umbralMinimo;
        this.descuentoAplicable = descuentoAplicable;
    }

    @Override
    public Money aplicar(Cart cart) {
        Money totalActual = cart.calcularTotal();

        // Verificamos si el total del carrito es mayor o igual al umbral
        if (totalActual.getMonto().compareTo(umbralMinimo.getMonto()) >= 0) {
            return descuentoAplicable.aplicar(cart);
        }

        // Si no llega al mínimo, el descuento es cero
        return Money.of(0, cart.getCodigoMoneda());
    }
}
