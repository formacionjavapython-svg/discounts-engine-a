package discounts;

import interfaz.DiscountRule;
import classes.Money;
import classes.Cart;

public class PercentDiscount implements DiscountRule {
    private final double porcentaje;

    public PercentDiscount(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public Money aplicar(Cart cart) {
        // El descuento es un % del total bruto
        return cart.calcularTotal().porciento(porcentaje);
    }
}
