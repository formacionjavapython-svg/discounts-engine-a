public class CouponDiscount implements DiscountRule {

    @Override
    public Money apply(Cart cart) {

        String userCoupon = "SUPER2024";
        String secret = System.getenv("DISCOUNT_COUPON_SECRET");

        if (secret != null && secureCompare(userCoupon, secret)) {
            return new Money(200, "MXN");
        }

        return new Money(0, "MXN");
    }

    private boolean secureCompare(String a, String b) {
        if (a.length() != b.length()) return false;

        int result = 0;
        for (int i = 0; i < a.length(); i++) {
            result |= a.charAt(i) ^ b.charAt(i);
        }
        return result == 0;
    }
}