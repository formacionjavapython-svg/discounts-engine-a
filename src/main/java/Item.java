public class Item {
    private final String name;
    private final Money unitPrice;
    private final int quantity;

    public Item(String name, Money unitPrice, int quantity) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }
        if (unitPrice == null) {
            throw new IllegalArgumentException("El precio unitario no puede ser nulo");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Money getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getSubtotal() {
        return unitPrice.multiply(quantity);
    }
}