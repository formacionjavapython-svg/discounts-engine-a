public class CouponDiscount implements DiscountRule {
    private final String expectedCode;
    private final String providedCode;
    private final Money discountAmount;

    public CouponDiscount(String expectedCode, String providedCode, Money discountAmount) {
        if (expectedCode == null || expectedCode.isBlank()) {
            throw new IllegalArgumentException("expectedCode es obligatorio");
        }
        if (providedCode == null || providedCode.isBlank()) {
            throw new IllegalArgumentException("providedCode es obligatorio");
        }
        if (discountAmount == null) {
            throw new IllegalArgumentException("discountAmount es obligatorio");
        }

        this.expectedCode = expectedCode;
        this.providedCode = providedCode;
        this.discountAmount = discountAmount;
    }

    @Override
    public Money apply(Cart cart) {
        Money total = cart.total();

        if (expectedCode.equals(providedCode)) {
            if (!discountAmount.getCurrency().equals(total.getCurrency())) {
                throw new IllegalArgumentException("la moneda del cupón no coincide con la del carrito");
            }
            return discountAmount;
        }

        return new Money(0, total.getCurrency());
    }
}