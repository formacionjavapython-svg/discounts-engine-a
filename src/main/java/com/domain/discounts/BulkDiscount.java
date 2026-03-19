package com.domain.discounts;

import com.domain.model.Cart;
import com.domain.model.Item;
import com.domain.model.Money;

public class BulkDiscount implements DiscountRule
{
    @Override
    public Money apply(Cart cart)
    {
        double discount = 0;

        for(Item item: cart.getItems())
        {
            if(item.getQuantity() >= 3)
            {
                discount += item.getSubtotal().getAmount() * 0.05;
            }
        }

        return new Money(discount, "MXN");
    }
}
