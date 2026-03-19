package service;

import model.Cart;
import model.Money;

// interfaz de descuento
public interface IDiscountRule {
    Money apply(Cart cart);
}
