package services;

import models.Money;

public class ThresholdDiscount implements DiscountRule {
    private Money money;
    private float discount;

    @Override
    public float apply(float amount) {
        return 0;
    }

    public ThresholdDiscount(Money money, float discount) {
        this.money = money;
        this.discount = discount;
    }
}
