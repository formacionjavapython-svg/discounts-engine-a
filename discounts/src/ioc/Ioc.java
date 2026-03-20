package ioc;

import controllers.MotorDescuento;
import models.Cart;
import models.Money;
import services.CouponDiscount;
import services.DiscountRule;
import services.ThresholdDiscount;

import java.util.List;

public class Ioc {
    public static Cart cartSale = new Cart();
    public static MotorDescuento motorDescuento = new MotorDescuento();
    public static List<DiscountRule> rules = List.of(new ThresholdDiscount(new Money(5000, "MXN"), 0.10f), new CouponDiscount("SUPER2024"));

}
