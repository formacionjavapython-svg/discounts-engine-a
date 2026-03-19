package test;

public class Assert {
    public static void assertEquals(Object esperado, Object real) {
        if (!esperado.equals(real)) {
            throw new AssertionError(
                    "\nEsperado: " + esperado +
                            "\nObtenido: " + real
            );
        }
        System.out.println("OK - esperado: " + esperado);
    }

    public static void assertTrue(boolean condicion, String mensaje) {
        if (!condicion) {
            throw new AssertionError("FALLO: " + mensaje);
        }
        System.out.println("OK - " + mensaje);
    }
}
