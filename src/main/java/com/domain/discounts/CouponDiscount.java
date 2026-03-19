package com.domain.discounts;

import com.domain.model.Cart;
import com.domain.model.Money;

import java.security.MessageDigest;

/**
 * Aqui aplicamos descuento por cupon
 * si nuestra variable de entorno = "CUPON2026"
 */
public class CouponDiscount implements DiscountRule
{
    @Override
    public Money apply(Cart cart)
    {
        String secret = System.getenv("DISCOUNT_COUPON_SECRET");

        if(secret != null && MessageDigest.isEqual(secret.getBytes(), "CUPON2026".getBytes()))
        {
            return new Money(200, "MXN");
        }
        return new Money(0, "MXN");
    }
}
