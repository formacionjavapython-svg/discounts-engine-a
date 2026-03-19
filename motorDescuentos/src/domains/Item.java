package domains;

public class Item {
    private final String name;
    private final Money unitPrice;
    private final int quantity;

    public Item(String name, Money unitPrice, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }
    public Money getSubtotal() {
        return unitPrice.multiply(quantity);
    }

    // getters para hacer cuentas
    public String getName() {
        return name;
    }
    public Money getUnitPrice() {
        return unitPrice;
    }
    public int getQuantity() {
        return quantity;
    }
}