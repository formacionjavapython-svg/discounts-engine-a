import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class CouponDiscount implements DiscountRule {
    private final String providedCode;
    private final Money discountAmount;

    public CouponDiscount(String providedCode, Money discountAmount) {
        if (providedCode == null || providedCode.isBlank()) {
            throw new IllegalArgumentException("providedCode es obligatorio");
        }
        if (discountAmount == null) {
            throw new IllegalArgumentException("discountAmount es obligatorio");
        }

        this.providedCode = providedCode;
        this.discountAmount = discountAmount;
    }

    @Override
    public Money apply(Cart cart) {
        Money total = cart.total();
        String secret = System.getenv("DISCOUNT_COUPON_SECRET");

        if (secret == null || secret.isBlank()) {
            return new Money(0, total.getCurrency());
        }

        if (!discountAmount.getCurrency().equals(total.getCurrency())) {
            throw new IllegalArgumentException("la moneda del cupón no coincide con la del carrito");
        }

        byte[] providedBytes = providedCode.getBytes(StandardCharsets.UTF_8);
        byte[] secretBytes = secret.getBytes(StandardCharsets.UTF_8);

        if (MessageDigest.isEqual(providedBytes, secretBytes)) {
            return discountAmount;
        }

        return new Money(0, total.getCurrency());
    }
}