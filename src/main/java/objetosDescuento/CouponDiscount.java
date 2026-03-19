package objetosDescuento;

public class CouponDiscount implements DiscountRule {
    @Override
    public Money apply(Cart cart) {
        // Lee la variable de entorno de tu Fedora
        String coupon = System.getenv("DISCOUNT_COUPON_SECRET");
        if ("PROMO2026".equals(coupon)) {
            return new Money(100, "MXN"); // Descuento fijo de $100
        }
        return new Money(0, "MXN");
    }
}
