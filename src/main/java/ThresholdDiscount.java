package src.main.java;

import java.math.BigDecimal;

/**
 * Clase para aplicar reglas de descuento
 */

public class ThresholdDiscount implements DiscountRule {

    private BigDecimal threshold;
    private BigDecimal percentage;

    public ThresholdDiscount(BigDecimal threshold, BigDecimal percentage) {
        this.threshold = threshold;
        this.percentage = percentage;
    }

    @Override
    public Money calcularDescuento(Cart carrito){
        Money total = carrito.calcularTotal();

        if((total.getMonto()).compareTo(threshold) >= 0){
            return total.multiplica(percentage);
        }

        return new Money(BigDecimal.valueOf(0),"MXN");

    }

}
