package com.domain.discounts;

import com.domain.model.Cart;
import com.domain.model.Money;

/**
 * Aquí descontamos si se supera cierto monto
 * como ejemplo sería que si el total es mayor a 5000 aplicamos el 10% de descuento
 */
public class ThresholdDiscount implements DiscountRule
{
    @Override
    public Money apply(Cart cart)
    {
        if(cart.getTotal().getAmount() > 5000)
        {
            return new Money(cart.getTotal().getAmount() * 0.10, "MXN");
        }
        return new Money(0, "MXN");
    }
}
