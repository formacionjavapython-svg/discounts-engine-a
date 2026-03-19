package modules.discounts.services;

import modules.discounts.dto.Money;
import modules.discounts.interfaces.DiscountRule;

public class ThresholdDiscount implements DiscountRule {

    private final Money threshold;
    private final double percentage;

    public ThresholdDiscount(Money threshold, double percentage) {
        if (threshold == null) {
            throw new IllegalArgumentException("Threshold is required");
        }
        if (percentage < 0 || percentage > 1) {
            throw new IllegalArgumentException("Percentage must be between 0 and 1");
        }
        this.threshold = threshold;
        this.percentage = percentage;
    }

    @Override
    public Money apply(CartService cart) {
        if (cart == null) {
            throw new IllegalArgumentException("Cart is required");
        }

        Money total = cart.total();

        if (total.getAmount().compareTo(threshold.getAmount()) >= 0) {
            return total.percentage(percentage);
        }

        return Money.zero(total.getCurrency());
    }
}