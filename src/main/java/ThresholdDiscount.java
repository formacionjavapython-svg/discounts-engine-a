/**
 * ThresholdDiscount - Descuento por alcanzar un monto mínimo
 */
public class ThresholdDiscount implements DiscountRule{

    private final int threshold;      // Monto mínimo 
    private final double percentage;  // Porcentaje de descuento
    
    public ThresholdDiscount(int threshold, double percentage) {
        if (threshold <= 0) {
            throw new IllegalArgumentException("El umbral debe ser positivo");
        }
        if (percentage <= 0 || percentage > 1) {
            throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 1");
        }
        this.threshold = threshold;
        this.percentage = percentage;
    }
    
    @Override
    public Money apply(Cart cart) {
        Money total = cart.getTotal();
        
        // Si el total es mayor al umbral, aplica descuento
        if (total.getAmount() > threshold) {
            int descuentoAmount = (int)(total.getAmount() * percentage);
            return new Money(descuentoAmount, total.getCurrency());
        }
        
        // Si no alcanza el umbral por lo tanto no hay descuento
        return new Money(0, total.getCurrency());
    }

}
