


public class Main {

    public static void main(String[] args) {
        
        Money money = new Money(1000,"MXN");
        Item item = new Item("Laptop", Money(15000,"MXN"), 2);
        Cart cart = new Cart();


        
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Descuento Total: " + totalDiscount);
        System.out.println("Total: " + totalDiscount);

    }
}
