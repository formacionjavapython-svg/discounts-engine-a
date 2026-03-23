package src.main.java;

/**
 * Interfaz para contrato de descuentos
 */

public interface DiscountRule {

    /**
     * Calcula el descuento basado en el contenido del carrito
     * @param carrito
     * @return monto
     */
    Money apply(Cart carrito);
}
