package objetosDescuento;

public class ThresholdDiscount implements DiscountRule {
    @Override
    public Money apply(Cart cart) {
        Money total = cart.calculateTotal();
        // Si el total es mayor a 5000, 10% de descuento
        if (total.getAmount() > 5000) {
            return new Money(total.getAmount() * 0.10, "MXN");// Truco para el 10% o hazlo directo:
            // return new Money(total.getAmount() * 0.10, "MXN");
        }
        return new Money(0, "MXN");
    }
}
