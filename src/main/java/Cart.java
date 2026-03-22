package src.main.java;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Clase de tipo cart que es el carrito de compras
 */
public class Cart {
    private final List<Item> items = new ArrayList<>();
    /**
     * MEtodo para agregar items a la lista
     * @param item
     */
    public void agregarItem(Item item){
        items.add(item);
    }

    /**
     * metodo que regresa la lista de los items
     * @return
     */
    public List<Item> getItems(){
        return Collections.unmodifiableList(items);
    }

    public void retirarItems(Item item){
        items.remove(item);
    }

    public Money calcularTotal(){
        Money total = new Money(BigDecimal.valueOf(0), "MXN");

        for(Item item:items){
            total = total.sumarDinero(item.obtenerSubtotal());
        }
        return total;
    }

}
