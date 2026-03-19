package main.java;

public class ThresholdDiscount implements DiscountRule {
    private double threshold;
    private double percentage;

    public ThresholdDiscount(double threshold, double percentage) {
        this.threshold = threshold;
        this.percentage = percentage;
    }

    @Override
    public double apply(Cart cart) {
        if (cart.getTotal() > threshold) {
            return cart.getTotal() * percentage;
        }
        return 0.0;
    }
}