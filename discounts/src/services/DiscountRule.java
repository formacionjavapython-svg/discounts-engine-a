package services;

import models.Cart;
import models.Money;

public interface DiscountRule {

    Money apply(Cart cart);

}
