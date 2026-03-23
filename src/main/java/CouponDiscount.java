package src.main.java;

import java.math.BigDecimal;
import java.security.MessageDigest;

/**
 * Clase para aplicar reglas de cupoines
 */
public class CouponDiscount {

    private String cuponUsuario;

    public CouponDiscount(String cupon){
        this.cuponUsuario = cuponUsuario;
    }

    public Money apply(Cart carrito){
        String secreto = System.getenv("DISCOUNT_COUPON_SECRET");

        if (secreto != null && validaCupon(cuponUsuario,secreto)){
            return carrito.calcularTotal().multiplica(BigDecimal.valueOf(0.15));
        }

        return new Money(BigDecimal.valueOf(0),"MXN");
    }

    private boolean validaCupon(String cuponUsuario,String cuponSistema){
        //No debemos comparar con string, se debe usar el MEssage /Digest
        //return cuponUsuario.equals(cuponSistema);

        return MessageDigest.isEqual(cuponUsuario.getBytes(), cuponSistema.getBytes());
    }

}
