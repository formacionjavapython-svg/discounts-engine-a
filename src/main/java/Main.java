import modules.discounts.dto.Money;
import modules.discounts.entity.Item;
import modules.discounts.interfaces.DiscountRule;
import modules.discounts.services.BulkDiscount;
import modules.discounts.services.CartService;
import modules.discounts.services.CouponDiscount;
import modules.discounts.services.ThresholdDiscount;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CartService cart = new CartService();

        cart.addItem(new Item("Laptop", Money.of(15000, "MXN"), 1));
        cart.addItem(new Item("Mouse", Money.of(500, "MXN"), 3));

        System.out.println("Total carrito: " + cart.total());

        List<DiscountRule> rules = List.of(
                new ThresholdDiscount(Money.of(5000, "MXN"), 0.10),
                new CouponDiscount("SUPER2024", Money.of(500, "MXN")),
                new BulkDiscount(3, 0.05)
        );

        Money totalDiscount = Money.zero(cart.total().getCurrency());

        for (DiscountRule rule : rules) {
            totalDiscount = totalDiscount.add(rule.apply(cart));
        }

        Money cartTotal = cart.total();

        if (totalDiscount.getAmount().compareTo(cartTotal.getAmount()) > 0) {
            totalDiscount = cartTotal;
        }

        Money finalTotal = cartTotal.subtract(totalDiscount);

        System.out.println("Descuento total: " + totalDiscount);
        System.out.println("Total final: " + finalTotal);
    }
}