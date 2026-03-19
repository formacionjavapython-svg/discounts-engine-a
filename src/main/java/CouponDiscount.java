package main.java;

public class CouponDiscount implements DiscountRule {
    private String couponCode;
    private double discountAmount;

    public CouponDiscount() {
        this.couponCode = "GENERICO";
        this.discountAmount = 50.0; // Un descuento base
    }

    public CouponDiscount(String code, double amount) {
        this.couponCode = code;
        this.discountAmount = amount;
    }

    @Override
    public double apply(Cart cart) {
        // En un caso real, aquí validaríamos si el cupón es válido
        // Por ahora, si el carrito no está vacío, aplicamos el descuento fijo
        return cart.getTotal() > 0 ? discountAmount : 0.0;
    }
}