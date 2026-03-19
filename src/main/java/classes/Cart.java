package classes;

import entity.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Gestiona la colección de items y el estado económico de la compra.
 */
public final class Cart {
    private final List<Item> items;
    private final String codigoMoneda;

    public Cart(String codigoMoneda) {
        this.items = new ArrayList<>();
        this.codigoMoneda = codigoMoneda;
    }

    /**
     * Agrega un item al carrito. 
     * Si el producto ya existe (mismo nombre y precio), se podría sumar la cantidad,
     * pero para mantenerlo simple y fiel a tu solicitud, lo agregamos a la lista.
     */
    public void agregar(Item nuevoItem) {
        verificarMoneda(nuevoItem.getPrecioUnitario());
        this.items.add(nuevoItem);
    }

    /**
     * Remueve un item de la lista por su índice.
     */
    public void remover(int indice) {
        if (indice >= 0 && indice < items.size()) {
            this.items.remove(indice);
        }
    }

    /**
     * Calcula el total bruto (sin descuentos aún) sumando los subtotales de cada item.
     */
    public Money calcularTotal() {
        return items.stream()
                .map(Item::calcularSubtotal)
                .reduce(Money.of(0, codigoMoneda), Money::sumar);
    }

    private void verificarMoneda(Money dineroItem) {
        if (!dineroItem.getMoneda().getCurrencyCode().equals(codigoMoneda)) {
            throw new IllegalArgumentException("El item usa una moneda distinta a la del carrito: " + codigoMoneda);
        }
    }

    // Retorna una vista no modificable de los items para proteger el estado interno
    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public String getCodigoMoneda() {
        return codigoMoneda;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("--- Detalle del Carrito ---\n");
        items.forEach(item -> sb.append(item.toString()).append("\n"));
        sb.append("TOTAL: ").append(calcularTotal());
        return sb.toString();
    }
}
