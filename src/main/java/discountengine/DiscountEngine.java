package discountengine;

import classes.Money;
import classes.Cart;
import interfaz.DiscountRule;
import java.util.List;

public final class DiscountEngine {

    /**
     * Procesa el carrito contra una lista de reglas y devuelve el total de descuentos.
     */
    public Money calcularDescuentoTotal(Cart cart, List<DiscountRule> reglas) {
        return reglas.stream()
                .map(regla -> regla.aplicar(cart))
                .reduce(Money.of(0, cart.getCodigoMoneda()), Money::sumar);
    }

    /**
     * Imprime un resumen completo del estado final del carrito.
     */
    public void procesarVenta(Cart cart, List<DiscountRule> reglas) {
        Money totalBruto = cart.calcularTotal();
        Money totalDescuentos = calcularDescuentoTotal(cart, reglas);
        Money totalNeto = totalBruto.restar(totalDescuentos);

        System.out.println("--- RESUMEN DE VENTA ---");
        System.out.println("Total Bruto:     " + totalBruto);
        System.out.println("Descuentos:    - " + totalDescuentos);
        System.out.println("------------------------");
        System.out.println("TOTAL A PAGAR:   " + totalNeto);
    }
}
