import ioc.Ioc;
import models.Item;
import models.Money;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Item item1 = new Item("Laptop", new Money(10000, "MXN"), 2);
        Item item2 = new Item("Celular", new Money(8000, "MXN"), 1);
        Item item3 = new Item("TV", new Money(5000, "MXN"), 9);

        Ioc.cartSale.addItem(item1);
        Ioc.cartSale.addItem(item2);
        Ioc.cartSale.removeItem(item3);

        Ioc.rules.forEach( discountRule -> {
            Money descuento = discountRule.apply(Ioc.cartSale);
            Ioc.cartSale = Ioc.cartSale.applyDiscount(descuento);
            System.out.println("Total a pagar con descuento: "+ Ioc.cartSale.getMoney().getMoney());
            System.out.println("Descuento aplicado: "+descuento.getMoney());
        });
    }
}