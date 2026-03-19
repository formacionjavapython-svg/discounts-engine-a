public class Item {
    private final String name;
    private final Money price;
    private final int quantity;

    public Item(String name, Money price, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Cantidad inválida");
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Money getSubtotal() {
        return price.multiply(quantity);
    }

    public String getName() {
        return name;
    }
}