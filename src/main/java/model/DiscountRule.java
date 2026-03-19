package model;

// interfaz de descuento
public interface DiscountRule {
    Money apply(Cart cart);
}
