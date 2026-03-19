package services;

import models.Cart;
import models.Money;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

public class CouponDiscount implements DiscountRule {

    private String codigo;
    private Money descuento;

    public CouponDiscount(){}

    public CouponDiscount(String codigo) {
        this.codigo = codigo;
        this.descuento = new Money(1000, "MXN");
    }

    @Override
    public Money apply(Cart cart) {
        String secret = System.getenv("DISCOUNT_COUPON_SECRET");
        byte[] secretToCompare = secret.getBytes(StandardCharsets.UTF_8);
        byte[] codigoToCompare = Base64.getDecoder().decode(codigo);

        if(MessageDigest.isEqual(secretToCompare, codigoToCompare)){
            return descuento;
        }
        return new Money(0, cart.calculateAmount().getType());
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Money getDescuento() {
        return descuento;
    }

    public void setDescuento(Money descuento) {
        this.descuento = descuento;
    }
}
