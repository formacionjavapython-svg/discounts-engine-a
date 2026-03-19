/**
 * CouponDiscount - Descuento fijo por tener un cupón
 */

public class CouponDiscount implements DiscountRule {
    private final int discountAmount; // Monto de descuento
    private final String secretCoupon;

    public CouponDiscount(int discountAmount) {
        if (discountAmount <= 0) {
            throw new IllegalArgumentException("El descuento debe ser positivo");
        }

        this.secretCoupon = System.getenv("DISCOUNT_COUPON_SECRET");

        if (this.secretCoupon == null || this.secretCoupon.isEmpty()) {
            System.out.println("ADVERTENCIA: Variable DISCOUNT_COUPON_SECRET no configurada, usando valor por defecto");
        }

        this.discountAmount = discountAmount;

    }

    @Override
    public Money apply(Cart cart) {
        Money total = cart.getTotal();

        if (discountAmount > total.getAmount()) {
            return new Money(total.getAmount(), total.getCurrency());
        }

        return new Money(discountAmount, total.getCurrency());
    }

    public boolean validarCupon(String cuponIngresado) {
        if (cuponIngresado == null) {
            System.out.println("Cupon nulo");
            return false;
        }

        boolean sonIguales = constantTimeEquals(this.secretCoupon, cuponIngresado);

        if (sonIguales) {
            System.out.println("[OK] Cupon valido");
        } else {
            System.out.println("[ERROR] Cupon invalido");
        }

        return sonIguales;
    }

    private boolean constantTimeEquals(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }

        int result = 0;

        for (int i = 0; i < a.length(); i++) {
            result = result | (a.charAt(i) ^ b.charAt(i));
        }

        return result == 0;
    }

}
