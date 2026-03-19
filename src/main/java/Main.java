public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();

        Item item1 = new Item("Laptop", new Money(15000, "MXN"), 1);
        Item item2 = new Item("Mouse", new Money(500, "MXN"), 2);

        cart.addItem(item1);
        cart.addItem(item2);

        Money total = cart.total();

        DiscountRule couponDiscount = new CouponDiscount(
                "PROMO10",
                new Money(1000, "MXN")
        );

        Money discount = couponDiscount.apply(cart);

        System.out.println("Total del carrito: " + total);
        System.out.println("Descuento por cupón: " + discount);
    }
}