package com.domain.discounts;

import com.domain.model.Cart;
import com.domain.model.Money;

/**
 * Creamos un contrato el cual dice
 * cualquier descuento debe saber aplicarse a un carrito o
 * Dame un carrito y te devuelvo cuanto descuento aplico
 */
public interface DiscountRule
{
    Money apply(Cart cart);
}
