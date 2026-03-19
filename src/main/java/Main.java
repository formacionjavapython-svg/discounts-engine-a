public class Main {
    public static void main(String[] args) {
        Money price = new Money(15000, "MXN");
        Item laptop = new Item("Laptop", price, 2);

        Cart cart = new Cart();
        cart.addItem(laptop);

        System.out.println("Total: " + cart.getTotal());
    }
}