import classes.Money;
import classes.Cart;
import entity.Item;
import interfaz.DiscountRule;
import discounts.BulkDiscount;
import discounts.ThresholdDiscount;
import discounts.PercentDiscount;
import discounts.CouponDiscount;
import discountengine.DiscountEngine;
import java.util.List;

public class Main {

    public static void main(String args[]) {
        System.out.println("Hello World");
        System.out.println("---------- Motor de descuestos --------------");
      // 1.Configurar
        Cart myCart = new Cart("USD");
        myCart.agregar(new Item("Smartphone", Money.of(800, "USD"), 1));
        myCart.agregar(new Item("Funda", Money.of(20, "USD"), 5)); // Total Bruto: $900
      // 2.Definir reglas
        List<DiscountRule> myPromos = List.of(
            new BulkDiscount(5, 5.0), // 5% por llevar 5+ artículos
            new ThresholdDiscount(Money.of(500, "USD"), new PercentDiscount(10.0)), // 10% por superar $500
            new CouponDiscount("PROMO2026", "PROMO2026", 15.0) // 15% por cupón válido
        );
      // 3.Ejecutar motor
        DiscountEngine motor = new DiscountEngine();
        motor.procesarVenta(myCart, myPromos);
    }
}
