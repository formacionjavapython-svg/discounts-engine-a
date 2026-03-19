import ioc.Ioc;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("---------- BIENVENIDO -----------");
            System.out.println(" Operacion a realizar: \n 1.- Agregar Item \n 2.- Elimanar Item \n 3.- Ingresar Cupon \n 4.- Terminar Compra \n 5.- Salir");
            try {
                int operation = sc.nextInt();
                switch (operation) {
                    case 1:
                        Ioc.motorDescuento.agregarItems(sc);
                        break;
                    case 2:
                        Ioc.motorDescuento.eliminarItem(sc);
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        exit = true;
                }
            }catch (Exception e){
                System.out.println("Operacion no soportada!");
            }
        }

    }
}