//Money.java
import java.math.BigDecimal;
import java.util.Objects;
import java.math.RoundingMode;

/**
 * Clase Money.java
 *
 * Representa cantidades monetarias
 * de forma segura. Inmutable, con
 * validaciones y operaciones
 * aritméticas
 *
 * @author: Martin Ortega
 */
public class Money {

    //Variable para controlar la moneda de cambio
    private final String moneda;

    //Variable que representa el monto de dinero
    private final BigDecimal monto;

    /**
     * Metodo consturctor
     * @param monto de tipo decimal para la cantidad
     * @param moneda de tipo string para la moneda de cambio
     */
    public Money(BigDecimal monto, String moneda){
        Objects.requireNonNull(monto, "Monto no puede ser nulo");
        Objects.requireNonNull(moneda, "Moneda no puede ser nulo");

        this.monto = monto.setScale(2,RoundingMode.HALF_UP);
        this.moneda = moneda;

    }

    /**
     * Metodo que devuelve el monto
     * @return BigDecimal monto
     */
    public BigDecimal getMonto(){
        return monto;
    }

    /**
     * Metodo que regresa la moneda
     * @return String Moneda
     */
    public String getMoneda(){
        return moneda;
    }

    /**
     * MEtodo que en base a una cantidad suma dinero
     * @param dinero
     * @return
     */
    public Money sumarDinero(Money dinero){
        return new Money((this.monto.add(dinero.monto)),this.moneda);
    }

    /**
     * Metodo para restar dinero
     * @param dinero de tipo Money al que se le puede hacer la operacion de resta
     * @return la resta
     */
    public Money restarDinero(Money dinero){
        return new Money(this.monto.subtract(dinero.monto),this.moneda);
    }

    public Money multiplica(Money dinero){
        return new Money(this.monto.multiply(dinero.monto),this.moneda);
    }


}
