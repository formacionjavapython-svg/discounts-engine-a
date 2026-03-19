package main.java;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.addItem(new Item("Laptop", 15000.0, 1));
        cart.addItem(new Item("Mouse", 500.0, 2));

        System.out.println("Total del carrito: $" + cart.getTotal());
    }
}