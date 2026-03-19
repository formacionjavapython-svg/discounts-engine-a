package modules.discounts.services;

import modules.discounts.dto.Money;
import modules.discounts.interfaces.DiscountRule;
import java.security.MessageDigest;

public class CouponDiscount implements DiscountRule {

    private final String appliedCoupon;
    private final Money discountAmount;

    public CouponDiscount(String appliedCoupon, Money discountAmount) {
        if (discountAmount == null) {
            throw new IllegalArgumentException("Discount amount is required");
        }
        this.appliedCoupon = appliedCoupon;
        this.discountAmount = discountAmount;
    }

    @Override
    public Money apply(CartService cart) {
        Money total = cart.total();

        String secret = System.getenv("DISCOUNT_COUPON_SECRET");

        if (secret == null || appliedCoupon == null) {
            return Money.zero(total.getCurrency());
        }

        boolean isValid = MessageDigest.isEqual(
                appliedCoupon.getBytes(),
                secret.getBytes()
        );

        if (isValid) {
            if (discountAmount.getAmount().compareTo(total.getAmount()) > 0) {
                return total;
            }
            return discountAmount;
        }

        return Money.zero(total.getCurrency());
    }
}