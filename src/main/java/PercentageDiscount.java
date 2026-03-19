public class PercentageDiscount implements DiscountRule {

    private final int percentage;

    public PercentageDiscount(int percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("porcentaje inválido");
        }
        this.percentage = percentage;
    }

    @Override
    public Money apply(Cart cart) {
        Money total = cart.total();
        int discountAmount = total.getAmount() * percentage / 100;
        return new Money(discountAmount, total.getCurrency());
    }
}