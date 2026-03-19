package service.impl;

import model.Cart;
import model.Money;
import service.IDiscountRule;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

// clase que representa un cupon de descuento fijo de 100 mxn, se compara con el campo del cupon del carrito para aplicar el descuento.
public class CouponIDiscount implements IDiscountRule {

    @Override
    public Money apply(Cart cart) {
        String secretCoupon = System.getenv("DISCOUNT_COUPON_SECRET"); // el cupon es guardado en una varible de entorno
        String userCoupon = cart.getAppliedCoupon();
        if (secretCoupon != null && userCoupon != null) {
            byte[] secretBytes = secretCoupon.getBytes(StandardCharsets.UTF_8);
            byte[] userBytes = userCoupon.getBytes(StandardCharsets.UTF_8);

            if (MessageDigest.isEqual(secretBytes, userBytes)) {
                return new Money(new java.math.BigDecimal("100.00"), "MXN");
            }
        }
        return new Money(BigDecimal.ZERO, "MXN");
    }
}
