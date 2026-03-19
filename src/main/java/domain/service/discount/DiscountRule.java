package domain.service.discount;

import domain.model.Cart;
import domain.model.Money;

public interface DiscountRule {
    Money apply(Cart cart);
}
