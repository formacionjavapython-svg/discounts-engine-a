# Motor de Descuentos en Java Puro

Laboratorio 2 | Bloque 2

| Campo | Valor |
|-------|-------|
| **Estudiante** | Iassiel Navih Meneses Gomez |
| **ID** | A36 |
| **Rama** | `iassiel-navih-meneses-gomez` |
| **GitHub** | MenesesGomezIassielNavih |
| **Java** | 17 |

---

## Descripcion

Motor de descuentos para un carrito de compras que aplica reglas de descuento de forma secuencial usando una cadena de reglas (patron Strategy con enfoque Map/Reduce).

Reglas implementadas: descuento por umbral de monto (ThresholdDiscount) y descuento por cupon con validacion segura (CouponDiscount).

---

## Estructura

```
src/main/java/
  Money.java            - Value Object (BigDecimal, inmutable)
  Item.java             - Producto del carrito
  Cart.java             - Carrito de compras
  DiscountRule.java     - Interfaz para reglas de descuento
  ThresholdDiscount.java - Descuento por umbral
  CouponDiscount.java   - Descuento por cupon (seguro)
  Main.java             - Punto de entrada

src/test/java/
  TestRunner.java       - 3 casos de prueba sin JUnit

scripts/
  checkstyle.sh         - Validacion de calidad de codigo
  run-tests.sh          - Compilacion y ejecucion de tests

.github/workflows/
  ci.yml                - Pipeline CI/CD
```

---

## Compilacion y Tests

```bash
# Compilar
javac -d out/classes src/main/java/*.java
javac -cp out/classes -d out/test-classes src/test/java/*.java

# Ejecutar tests
java -cp out/classes:out/test-classes TestRunner          # Linux/Mac
java -cp "out/classes;out/test-classes" TestRunner         # Windows
```

### Salida esperada

```
=== MOTOR DE DESCUENTOS - TEST SUITE ===

  PASS: Caso 1: Cart calcula subtotal correctamente
  PASS: Caso 2: ThresholdDiscount aplica 10% sobre $5000
  PASS: Caso 3: CouponDiscount retorna $0 con cupon invalido

========================================
  RESULTADOS: 3 passed, 0 failed, 3 total
========================================
```

---

## Variable de Entorno

El cupon de descuento se valida contra una variable de entorno:

```bash
export DISCOUNT_COUPON_SECRET="<valor>"    # Linux/Mac
$env:DISCOUNT_COUPON_SECRET="<valor>"      # PowerShell
```

Sin esta variable, el descuento por cupon no se aplica pero los tests pasan correctamente.

---

## Pipeline CI/CD

| Job | Descripcion | Estado |
|-----|-------------|--------|
| Build & Test | Compila y ejecuta TestRunner | Passed |
| Checkstyle Quality | Valida convenciones de codigo | Passed |
| Security Analysis | CodeQL SAST | Passed |
