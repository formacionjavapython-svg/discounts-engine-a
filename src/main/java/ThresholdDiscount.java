public class ThresholdDiscount implements DiscountRule {

    private double threshold;
    private double percentage;

    public ThresholdDiscount(double threshold, double percentage) {
        this.threshold = threshold;
        this.percentage = percentage;
    }

    @Override
    public Money apply(Cart cart) {
        if (cart.getTotal().getAmount() > threshold) {
            double discount = cart.getTotal().getAmount() * percentage;
            return new Money(discount, "MXN");
        }
        return new Money(0, "MXN");
    }
}