package test;

import models.Cart;
import models.Item;
import models.Money;
import services.CouponDiscount;
import services.ThresholdDiscount;

import java.util.List;

public class TestCasero {
//    Caso 1
    private static final Item ITEM1 = new Item("Laptop", new Money(10000, "MXN"), 2);
    private static final Item ITEM2 = new Item("Celular", new Money(8000, "MXN"), 1);
    private static final Item ITEM3 = new Item("TV", new Money(5000, "MXN"), 9);
    private static final List<Item> ITEMISATION = List.of(ITEM1, ITEM2, ITEM3);
    private static final Cart CART1 = new Cart(ITEMISATION, new Money(0, "MXN"));

//    Caso 2 - valor de compra superior a 5000
    private static final ThresholdDiscount THRESHOLD_DISCOUNT = new ThresholdDiscount(new Money(5000, "MXN"), 0.10f);
    private static final Money DESCUENTO = THRESHOLD_DISCOUNT.apply(CART1);
//    Caso 2 - valor de compra inferior a 5000
    private static final Item ITEM4 = new Item("Lapiz", new Money(5, "MXN"), 2);
    private static final Item ITEM5 = new Item("Libreta", new Money(20, "MXN"), 4);
    private static final List<Item> ITEMISATION2 = List.of(ITEM4, ITEM5);
    private static final ThresholdDiscount THRESHOLD_DISCOUNT2 = new ThresholdDiscount(new Money(5000, "MXN"), 0.10f);
    private static final Cart CART2 = new Cart(ITEMISATION2, new Money(0, "MXN"));
    private static final Money DESCUENTO2 = THRESHOLD_DISCOUNT2.apply(CART2);

//Caso 3
    private static final CouponDiscount COUPON_DISCOUNT = new CouponDiscount("MAYO10");

    public static void main(String[] args) {
        TestRunner.ejecutar("Subtotal es igual al esperado", () -> {
            Assert.assertEquals(73000f, CART1.calculateAmount().getMoney());
        });

        TestRunner.ejecutar("Descuento Threshold aplicado correctamente", () -> {
            Assert.assertTrue(DESCUENTO.getMoney() > 500f, "Descuento superior a 500 que es el 10% de 5000, en caso de ser menor a 500 debia ser un descuento de 0");
        });

        TestRunner.ejecutar("Descuento Threshold no aplicado por valor inferior a 5000 en cart2", () -> {
            Assert.assertTrue(DESCUENTO2.getMoney() == 0f, "Al ser "+CART2.calculateAmount().getMoney()+" el total de cart2 no aplica el descuento");
        });

        TestRunner.ejecutar("Descuento no aplicado por cupon invalido", () -> {
            Assert.assertEquals(0f, COUPON_DISCOUNT.apply(CART1).getMoney());
        });
    }

}