/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package laboratorio;

/**
 *
 * @author sam87
 */
public interface DiscountRule {
    /**
     * Aplica una lógica de descuento al carrito actual.
     * @param cart El carrito sobre el cual se calcula el descuento.
     * @return Un objeto Money con el monto a descontar.
     */
    Money apply(Cart cart); 
}
