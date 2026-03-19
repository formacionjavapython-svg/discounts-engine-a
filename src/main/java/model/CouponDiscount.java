package model;

import java.math.BigDecimal;

// clase que representa un cupon de descuento fijo de 100 mxn, se compara con el campo del cupon del carrito para aplicar el descuento.
public class CouponDiscount implements DiscountRule {
    @Override
    public Money apply(Cart cart) {
        if ("AXITY2026".equals(cart.getAppliedCoupon())) {
            return new Money(new BigDecimal("100.00"), "MXN");
        }
        return new Money(BigDecimal.ZERO, "MXN");
    }
}
