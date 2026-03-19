package main.java;

import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;

public class CouponDiscount implements DiscountRule {
    private String userProvidedCode;
    private double discountAmount;

    public CouponDiscount(String userProvidedCode, double amount) {
        this.userProvidedCode = userProvidedCode;
        this.discountAmount = amount;
    }

    @Override
    public double apply(Cart cart) {

        String realSecret = System.getenv("DISCOUNT_COUPON_SECRET");

        if (realSecret == null || userProvidedCode == null) {
            return 0.0;
        }

        boolean isValid = MessageDigest.isEqual(
                realSecret.getBytes(StandardCharsets.UTF_8),
                userProvidedCode.getBytes(StandardCharsets.UTF_8));

        return isValid ? discountAmount : 0.0;
    }
}