package test;

public class TestRunner {
    private static int pasados = 0;
    private static int fallidos = 0;

//    Ejecutandor de los asserts
    public static void ejecutar(String nombre, Runnable test) {
        try {
            test.run();
            pasados++;
            System.out.println("[PASO] " + nombre);
        } catch (AssertionError | Exception ex) {
            fallidos++;
            System.out.println("[FALLO] " + nombre);
            System.out.println("        " + ex.getMessage());
        }
    }

    public static void resumen() {
        System.out.println("\n══════════════════════════════");
        System.out.println("  Pasados : " + pasados);
        System.out.println("  Fallidos: " + fallidos);
        System.out.println("  Total   : " + (pasados + fallidos));
        System.out.println("══════════════════════════════");
        if (fallidos > 0) {
            System.exit(1);
        }
    }
}
