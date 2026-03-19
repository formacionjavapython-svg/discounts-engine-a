package domain.model;

public class Item {
    private final String name;
    private final Money unitPrice;
    private int quantity;

    public Item(String name, Money unitPrice, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public Money getSubtotal() {
        return unitPrice.multiply(quantity);
    }

    // Getters y setters básicos
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
