/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio;



public class ThresholdDiscount implements DiscountRule {
    @Override
    public Money apply(Cart cart) {
        Money total = cart.calculateTotal();
        if (total.amount() > 200) {
            return total.multiply(0.10); 
        }
        return new Money(0, "MXN");
    }
}