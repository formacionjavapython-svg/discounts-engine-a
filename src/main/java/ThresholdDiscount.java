public class ThresholdDiscount implements DiscountRule {
    private final int threshold;
    private final double percentage;

    public ThresholdDiscount(int threshold, double percentage) {
        if (threshold < 0) {
            throw new IllegalArgumentException("threshold no puede ser negativo");
        }
        if (percentage < 0 || percentage > 1) {
            throw new IllegalArgumentException("percentage debe estar entre 0 y 1");
        }
        this.threshold = threshold;
        this.percentage = percentage;
    }

    @Override
    public Money apply(Cart cart) {
        Money total = cart.total();

        if (total.getAmount() > threshold) {
            int discountAmount = (int) (total.getAmount() * percentage);
            return new Money(discountAmount, total.getCurrency());
        }

        return new Money(0, total.getCurrency());
    }
}
