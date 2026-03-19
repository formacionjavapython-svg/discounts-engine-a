package src.main.java;

import java.math.BigDecimal;

public class Item {

    private final String nombre;
    private final Money precio;
    private final int cantidad;

    /**
     * Metodo constructor
     *
     * @param nombre   nombre del objeto
     * @param precio   precio del objeto de tipo Money
     * @param cantidad cantidad
     */
    public Item(String nombre, Money precio, int cantidad) {

        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre(){
        return nombre;
    }

    public Money getPrecio() {
        return precio;
    }

    public int getCantidad(){
        return cantidad;
    }

    /**
     * Metodo que devuelve el subtotal cantidad * [precio
     * @return
     */
    public Money obtenerSubtotal(){
        return precio.multiplica(new BigDecimal(cantidad));
    }
}
