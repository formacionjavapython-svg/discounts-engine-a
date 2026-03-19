package  modules.discounts.interfaces;


import modules.discounts.dto.Money;
import modules.discounts.services.CartService;

public interface DiscountRule {
    Money apply(CartService cart);
}