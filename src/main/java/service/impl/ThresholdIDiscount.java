package service.impl;

import model.Cart;
import model.Money;
import service.IDiscountRule;

import java.math.BigDecimal;

// descueto por monto minimo
public class ThresholdIDiscount implements IDiscountRule {
    private final BigDecimal threshold = new BigDecimal("5000");
    private final BigDecimal discountRate = new BigDecimal("0.10");


    @Override
    public Money apply(Cart cart) {
        Money total = cart.calculateTotal();
        if (total.amount().compareTo(threshold) > 0) {
            BigDecimal discountAmount = total.amount().multiply(discountRate);
            return new Money(discountAmount, total.currency());
        }

        return new Money(BigDecimal.ZERO, total.currency());
    }
}
