package entity;

import classes.Money;
import java.util.Objects;


/**
 * Representa un producto dentro de un contexto de compra.
 * Es inmutable para asegurar la integridad durante el cálculo de descuentos.
 */
public final class Item {
    private final String nombre;
    private final Money precioUnitario;
    private final int cantidad;

    public Item(String nombre, Money precioUnitario, int cantidad) {
        validar(nombre, precioUnitario, cantidad);
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    private void validar(String nombre, Money precioUnitario, int cantidad) {
        Objects.requireNonNull(nombre, "El nombre del producto no puede ser nulo");
        Objects.requireNonNull(precioUnitario, "El precio unitario no puede ser nulo");
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }
    }

    /**
     * Calcula el subtotal multiplicando el precio unitario por la cantidad.
     * @return Un nuevo objeto Dinero con el total del item.
     */
    public Money calcularSubtotal() {
        return precioUnitario.multiplicar(cantidad);
    }

    // Getters
    public String getNombre() { return nombre; }
    public Money getPrecioUnitario() { return precioUnitario; }
    public int getCantidad() { return cantidad; }

    @Override
    public String toString() {
        return String.format("%s (x%d) - Unitario: %s - Subtotal: %s", 
                nombre, cantidad, precioUnitario, calcularSubtotal());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return cantidad == item.cantidad && 
               nombre.equals(item.nombre) && 
               precioUnitario.equals(item.precioUnitario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, precioUnitario, cantidad);
    }
}
