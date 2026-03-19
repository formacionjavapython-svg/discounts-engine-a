package src.main.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Clase de tipo cart que es el carrito de compras
 */
public class Cart {
    private final List<Item> items = new ArrayList<>();
    private final String moneda;

    public cart(String moneda){
        this.moneda = moneda;
    }

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
        Money subtotal = obtenerSubtotal();
        Money descuentoTotal = c
        return subtotal.restarDinero(descuentoTotal);
    }

}
