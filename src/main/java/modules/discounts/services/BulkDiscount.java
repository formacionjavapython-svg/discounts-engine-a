package modules.discounts.services;

import modules.discounts.dto.Money;
import modules.discounts.entity.Item;
import modules.discounts.interfaces.DiscountRule;

public class BulkDiscount implements DiscountRule {

    private final int minimumQuantity;
    private final double percentage;

    public BulkDiscount(int minimumQuantity, double percentage) {
        if (minimumQuantity <= 1) {
            throw new IllegalArgumentException("Minimum quantity must be greater than 1");
        }
        if (percentage < 0 || percentage > 1) {
            throw new IllegalArgumentException("Percentage must be between 0 and 1");
        }

        this.minimumQuantity = minimumQuantity;
        this.percentage = percentage;
    }

    @Override
    public Money apply(CartService cart) {
        if (cart == null) {
            throw new IllegalArgumentException("Cart is required");
        }

        if (cart.getItems().isEmpty()) {
            return Money.zero("MXN");
        }

        String currency = cart.getItems().get(0).getUnitPrice().getCurrency();
        Money totalDiscount = Money.zero(currency);

        for (Item item : cart.getItems()) {
            if (item.getQuantity() >= minimumQuantity) {
                totalDiscount = totalDiscount.add(item.subtotal().percentage(percentage));
            }
        }

        return totalDiscount;
    }
}