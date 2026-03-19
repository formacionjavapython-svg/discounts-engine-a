package com.domain;

import com.domain.discounts.BulkDiscount;
import com.domain.discounts.CouponDiscount;
import com.domain.discounts.DiscountRule;
import com.domain.discounts.ThresholdDiscount;
import com.domain.model.Cart;
import com.domain.model.Item;
import com.domain.model.Money;
import com.domain.service.DiscountService;

import java.util.List;

/**
 * Invocamos los 3 descuentos, cupones y total, y cuando es mayor a 5000 da el descuento del 10%
 * después si, se cumple la validation del cupon este da un descuento de 200, y está protegido
 * por variable de entorno
 */
public class Main {
    public static void main(String[] args)
    {
        Cart cart = new Cart();

        cart.addItem(new Item("Guitarra", new Money(4000, "MXN"), 1));
        cart.addItem(new Item("Bajo", new Money(4000, "MXN"), 3));

        List<DiscountRule> rules = List.of(
                new ThresholdDiscount(),
                new CouponDiscount(),
                new BulkDiscount()
        );

        DiscountService service = new DiscountService(rules);

        Money discount = service.applyDiscounts(cart);
        Money finalTotal = cart.getTotal().subtract(discount);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Descuento: " + discount);
        System.out.println("Total final: " + finalTotal);
    }
}