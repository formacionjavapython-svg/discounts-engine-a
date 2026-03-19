import java.security.MessageDigest;

public class CouponDiscount implements DiscountRule {
    private final String providedCoupon;
    private final double discountPercentage;

    public CouponDiscount(String providedCoupon, double discountPercentage) {
        this.providedCoupon = providedCoupon != null ? providedCoupon : "";
        this.discountPercentage = discountPercentage;
    }

    @Override
    public Money apply(Cart cart) {
        String secretCoupon = System.getenv("DISCOUNT_COUPON_SECRET");

        if (secretCoupon == null || secretCoupon.isEmpty()) {
            return new Money(0, cart.calculateTotal().getCurrency());
        }

        boolean isValid = MessageDigest.isEqual(
                providedCoupon.getBytes(),
                secretCoupon.getBytes()
        );

        if (isValid) {
            return cart.calculateTotal().multiply(discountPercentage);
        }

        return new Money(0, cart.calculateTotal().getCurrency());
    }
}