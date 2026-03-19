package classes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Objects;

/**
 * Representa una cantidad monetaria inmutable y segura.
 */
public final class Money {
    private final BigDecimal monto;
    private final Currency moneda;

    private Money(BigDecimal monto, Currency moneda) {
        validar(monto, moneda);
        // Usamos escala de 2 decimales y redondeo bancario (HALF_EVEN)
        this.monto = monto.setScale(2, RoundingMode.HALF_EVEN);
        this.moneda = moneda;
    }
    
    // Factory Method
    public static Money of(double amount, String currencyCode) {
        return new Money(BigDecimal.valueOf(amount), Currency.getInstance(currencyCode));
    }

    public static Money of(BigDecimal amount, Currency currency) {
        return new Money(amount, currency);
    }

    private void validar(BigDecimal monto, Currency moneda) {
        Objects.requireNonNull(monto, "El monto no puede ser nulo");
        Objects.requireNonNull(moneda, "La moneda no puede ser nula");
        if (monto.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo");
        }
    }

    // Operaciones Aritméticas
    public Money sumar(Money otro) {
        verificarMismaMoneda(otro);
        return new Money(this.monto.add(otro.monto), this.moneda);
    }

    public Money restar(Money otro) {
        verificarMismaMoneda(otro);
        BigDecimal resultado = this.monto.subtract(otro.monto);
        // Garantizamos que el descuento no resulte en saldos negativos
        return new Money(resultado.max(BigDecimal.ZERO), this.moneda);
    }

    public Money multiplicar(double factor) {
        return new Money(this.monto.multiply(BigDecimal.valueOf(factor)), this.moneda);
    }

    public Money porciento(double porcentaje) {
        return this.multiplicar(porcentaje / 100.0);
    }

    private void verificarMismaMoneda(Money otro) {
        if (!this.moneda.equals(otro.moneda)) {
            throw new IllegalArgumentException("No se pueden operar monedas distintas: " 
                + this.moneda + " vs " + otro.moneda);
        }
    }

    // Getters
    public BigDecimal getMonto() { return monto; }
    public Currency getMoneda() { return moneda; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money dinero = (Money) o;
        return monto.compareTo(dinero.monto) == 0 && moneda.equals(dinero.moneda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monto, moneda);
    }

    @Override
    public String toString() {
        return moneda.getSymbol() + " " + monto.toString();
    }
}
