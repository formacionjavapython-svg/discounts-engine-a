package ioc;

import controllers.MotorDescuento;
import models.Cart;
import models.Money;
import services.CouponDiscount;
import services.DiscountRule;
import services.ThresholdDiscount;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Ioc {
    public static Cart cartSale = new Cart();
    public static MotorDescuento motorDescuento = new MotorDescuento();
    public static Map<String, DiscountRule> rules = Map.of("threshold", new ThresholdDiscount(new Money(5000, "MXN"), 0.10f), "coupon", new CouponDiscount("SUPER2024"));

}
