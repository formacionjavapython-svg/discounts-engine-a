package services;

import models.Cart;
import models.Money;

public class ThresholdDiscount implements DiscountRule {
    private Money limiteDescuento;
    private float discount;

    public ThresholdDiscount(Money limiteDescuento, float discount) {
        this.limiteDescuento = limiteDescuento;
        this.discount = discount;
    }

    @Override
    public Money apply(Cart cart) {
        Money amount = cart.calculateAmount();
        if (Float.compare(amount.getMoney(), this.limiteDescuento.getMoney()) > 0){
            float descuento = new Money(amount.getMoney()*discount, amount.getType() ).getMoney();
            return new Money(descuento, this.limiteDescuento.getType());
        }
        return new Money(0, this.limiteDescuento.getType());
    }
}
