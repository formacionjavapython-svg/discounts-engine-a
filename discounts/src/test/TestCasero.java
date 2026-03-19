package test;

import ioc.Ioc;
import models.Cart;
import models.Item;
import models.Money;
import services.CouponDiscount;
import services.ThresholdDiscount;

import java.util.List;

public class TestCasero {
//    Caso 1
    private static final Item item1 = new Item("Laptop", new Money(10000, "MXN"), 2);
    private static final Item item2 = new Item("Celular", new Money(8000, "MXN"), 1);
    private static final Item item3 = new Item("TV", new Money(5000, "MXN"), 9);
    private static final List<Item> itemsOnCart = List.of(item1, item2, item3);
    private static final Cart cart1 = new Cart(itemsOnCart, new Money(0, "MXN"));

//    Caso 2 - valor de compra superior a 5000
    private static final ThresholdDiscount thresholdDiscount = new ThresholdDiscount(new Money(5000, "MXN"), 0.10f);
    private static final Money descuento = thresholdDiscount.apply(cart1);
//    Caso 2 - valor de compra inferior a 5000
    private static final Item item4 = new Item("Lapiz", new Money(5, "MXN"), 2);
    private static final Item item5 = new Item("Libreta", new Money(20, "MXN"), 4);
    private static final List<Item> itemsOnCart2 = List.of(item4, item5);
    private static final ThresholdDiscount thresholdDiscount2 = new ThresholdDiscount(new Money(5000, "MXN"), 0.10f);
    private static final Cart cart2 = new Cart(itemsOnCart2, new Money(0, "MXN"));
    private static final Money descuento2 = thresholdDiscount.apply(cart2);

//Caso 3
    private static final CouponDiscount couponDiscount = new CouponDiscount("MAYO10");

    public static void main(String[] args) {
        TestRunner.ejecutar("Subtotal es igual al esperado", () -> {
            Assert.assertEquals(73000f, cart1.calculateAmount().getMoney());
        });

        TestRunner.ejecutar("Descuento Threshold aplicado correctamente", () -> {
            Assert.assertTrue(descuento.getMoney() > 500f, "Descuento superior a 500 que es el 10% de 5000, en caso de ser menor a 500 debia ser un descuento de 0");
        });

        TestRunner.ejecutar("Descuento Threshold no aplicado por valor inferior a 5000 en cart2", () -> {
            Assert.assertTrue(descuento2.getMoney() == 0f, "Al ser "+cart2.calculateAmount().getMoney()+" el total de cart2 no aplica el descuento");
        });

        TestRunner.ejecutar("Descuento no aplicado por cupon invalido", () -> {
            Assert.assertEquals(0f, couponDiscount.apply(cart1).getMoney());
        });
    }

}