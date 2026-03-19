package rules;
import domains.*;

public class Descuento10 implements DiscountRule {

    @Override
    public Money apply(Cart cart) {
        double totalCarrito = cart.calculateTotal().getAmount();
            // calculamos el 10% de descuento
            double montoDescuento = totalCarrito * 0.10;
            return new Money(montoDescuento, "MXN");
    }
}
