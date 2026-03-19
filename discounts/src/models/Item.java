package models;

public class Item {
    private String name;
    private float quantity;
    private Money price;

    public Item(String name, Money money, float cantidad) {
        this.name = name;
        this.price = money;
        this.quantity = cantidad;
    }

    public Money calculateSubtotal(){
        return new Money(price.getMoney() * quantity, "MXN");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Money getMoney() {
        return price;
    }

    public void setMoney(Money money) {
        this.price = money;
    }
}
