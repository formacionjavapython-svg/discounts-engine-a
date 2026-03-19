package model;

import java.math.BigDecimal;

// descueto por monto minimo
public class ThresholdDiscount implements DiscountRule{
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
