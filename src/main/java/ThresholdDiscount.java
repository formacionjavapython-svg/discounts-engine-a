import java.math.BigDecimal;

public class ThresholdDiscount implements DiscountRule {
    private final Money threshold;
    private final double discountPercentage;

    public ThresholdDiscount(double thresholdAmount, double discountPercentage, String currency) {
        if (discountPercentage <= 0 || discountPercentage > 1) {
            throw new IllegalArgumentException("El porcentaje de descuento debe estar entre 0 y 1");
        }
        this.threshold = new Money(thresholdAmount, currency);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public Money apply(Cart cart) {
        Money total = cart.calculateTotal();

        if (total.getAmount().compareTo(threshold.getAmount()) >= 0) {
            return total.multiply(discountPercentage);
        }

        return new Money(0, total.getCurrency());
    }
}