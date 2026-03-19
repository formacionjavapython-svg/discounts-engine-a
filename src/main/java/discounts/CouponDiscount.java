package discounts;

import classes.Cart;
import classes.Money;
import interfaz.DiscountRule;
/**
 * Regla de cupón que contiene su propia lógica de descuento.
 */
public class CouponDiscount implements DiscountRule {
    private final String codigoCupon;
    private final String codigoIngresado;
    private final double porcentajeRebaja; // Por ejemplo, un 10%

    public CouponDiscount(String codigoCupon, String codigoIngresado, double porcentajeRebaja) {
        this.codigoCupon = codigoCupon;
        this.codigoIngresado = codigoIngresado;
        this.porcentajeRebaja = porcentajeRebaja;
    }

    @Override
    public Money aplicar(Cart cart) {
        // Si el código no coincide, el descuento es cero
        if (!codigoCupon.equalsIgnoreCase(codigoIngresado)) {
            return Money.of(0, cart.getCodigoMoneda());
        }

        // Si coincide, aplicamos el porcentaje sobre el total del carrito
        return cart.calcularTotal().porciento(porcentajeRebaja);
    }
}
