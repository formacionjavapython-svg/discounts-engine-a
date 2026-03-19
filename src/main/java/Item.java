public class Item {
    private final String name;
    private final Money price;
    private final int quantity;

    public Item(String name, Money price, int quantity) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name es obligatorio");
        }
        if (price == null) {
            throw new IllegalArgumentException("price es obligatorio");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity debe ser mayor a 0");
        }

        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money total() {
        return price.multiply(quantity);
    }
}