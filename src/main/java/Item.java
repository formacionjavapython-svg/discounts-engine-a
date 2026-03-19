public class Item {

    private String name;
    private Money unitPrice;
    private int quantity;

    public Item(String name, Money unitPrice, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public Money subtotal() {
    }


}
