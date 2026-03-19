/**
 * DiscountRule - Contrato para reglas de descuento
 */
public interface DiscountRule {

    Money apply(Cart cart);

}
