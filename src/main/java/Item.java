/**
 * Item representa un producto en el carrito
 * Tiene nombre, precio unitario y cantidad
 */

public class Item {
    private final String name;
    private final Money unitPrice;
    private final int quantity;

    public Item(String name, Money unitPrice, int quantity) {
        // Se hacen validaciones del nobre, precio unitario y cantidad de articulos
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto es requerido");
        }
        if (unitPrice == null) {
            throw new IllegalArgumentException("El precio unitario es requerido");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }

        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    // solo getters
    public String getName() {
        return name;
    }

    public Money getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    /* Calcula el subtotal = precio unitario * cantidad */
    public Money getSubtotal() {
        int subtotalAmount = unitPrice.getAmount() * quantity;
        return new Money(subtotalAmount, unitPrice.getCurrency());
    }

}
