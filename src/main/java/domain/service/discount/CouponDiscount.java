package domain.service.discount;

import domain.model.Cart;
import domain.model.Money;

public class CouponDiscount implements DiscountRule {
    private final Money discountAmount;

    public CouponDiscount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public Money apply(Cart cart) {
        if (cart.getItems().isEmpty()) {
            return new Money(0, discountAmount.getCurrency());
        }
        return discountAmount;
    }
}
