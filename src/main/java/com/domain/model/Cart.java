package com.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Agrega productos
 * Obtiene la lista
 * Calcula el total de los items
 */
public class Cart
{
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item)
    {
        items.add(item);
    }

    public List<Item> getItems()
    {
        return items;
    }

    public Money getTotal()
    {
        double total = 0;

        for(Item item : items)
        {
            total += item.getSubtotal().getAmount();
        }
        return new Money(total, "MXN");
    }
}
