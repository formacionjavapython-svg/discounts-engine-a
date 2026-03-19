/**
 * CouponDiscount - Descuento fijo por tener un cupón
 */

public class CouponDiscount implements DiscountRule{
    private final int discountAmount;  // Monto de descuento    
    
    public CouponDiscount(int discountAmount) {
        if (discountAmount <= 0) {
            throw new IllegalArgumentException("El descuento debe ser positivo");
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
    
}
