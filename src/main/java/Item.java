public class Item {

    private String name;
    private Money price;
    private int quantity;

    public Item(String name, Money price, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Money getSubtotal() {
        double total = price.getAmount() * quantity;
        return new Money(total, price.getCurrency());
    }
}