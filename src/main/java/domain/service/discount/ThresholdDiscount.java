package domain.service.discount;

import domain.model.Cart;
import domain.model.Money;

public class ThresholdDiscount implements DiscountRule {
    private final double threshold;
    private final double percentage;

    public ThresholdDiscount(double threshold, double percentage) {
        this.threshold = threshold;
        this.percentage = percentage;
    }

    @Override
    public Money apply(Cart cart) {
        Money subtotal = cart.calculateSubtotal();
        if (subtotal.getAmount() >= threshold) {
            return new Money(subtotal.getAmount() * percentage, subtotal.getCurrency());
        }
        return new Money(0, subtotal.getCurrency());
    }
}
