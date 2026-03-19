/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio;

/**
 *
 * @author sam87
 */

    public record Item(String name, Money unitPrice, int quantity) {
    public Money getSubtotal() {
        return unitPrice.multiply(quantity);
    }
}
