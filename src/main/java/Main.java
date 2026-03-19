
import objetosDescuento.*;

import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main (String[] args ){
        Cart cart = new Cart();

        // AGREGA ESTA LÍNEA: Un producto de 6000 para que aplique el 10%
        cart.addItem(new Item("Laptop Gamer", new Money(6000, "MXN"), 1));

        List<DiscountRule> rules = new ArrayList<>();
        rules.add(new ThresholdDiscount());
        rules.add(new CouponDiscount());

        Money totalDescuentos = new Money(0, "MXN");
        for (DiscountRule rule : rules) {
            totalDescuentos = totalDescuentos.sumar(rule.apply(cart));
        }

        System.out.println("Total Bruto: " + cart.calculateTotal().getAmount());
        System.out.println("Total Descuentos: " + totalDescuentos.getAmount());
    }
    }
