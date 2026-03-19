package services;

public class CouponDiscount implements DiscountRule {
    @Override
    public float apply(float amount) {
        return 0;
    }

    public CouponDiscount(){}
}
