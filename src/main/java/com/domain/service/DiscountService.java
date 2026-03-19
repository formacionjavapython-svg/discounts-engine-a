package com.domain.service;

import com.domain.discounts.DiscountRule;
import com.domain.model.Cart;
import com.domain.model.Money;

import java.util.List;

public class DiscountService
{
    private List<DiscountRule> rules;

    public DiscountService(List<DiscountRule> rules)
    {
        this.rules = rules;
    }

    public Money applyDiscounts(Cart cart)
    {
        Money totalDiscount = new Money(0, "MXN");

        for(DiscountRule rule: rules)
        {
            totalDiscount = totalDiscount.add(rule.apply(cart));
        }

        return totalDiscount;
    }
}
