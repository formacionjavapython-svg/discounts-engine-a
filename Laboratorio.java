/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package laboratorio;

/**
 *
 * @author sam87
 */

public class Laboratorio {

  // O el nombre que tenga tu archivo
    
    // El método main es el ÚNICO punto de entrada
    public static void main(String[] args) {
        
        // 1. Declaración del arreglo (Crítica: tamaño fijo de 5 es poco flexible)
        Producto[] R = new Producto[5];

        // 2. Instanciación
        R[0] = new Producto("papas", 15);
        R[1] = new Producto("pollo", 200);
        R[2] = new Producto("jabon", 50);
        R[3] = new Producto("agua", 20);
        R[4] = new Producto("harina", 80);

        // 3. Lógica de salida para probar
        double total = 0;
        for (Producto p : R) {
            System.out.println("Producto: " + p.nombre + " - Precio: " + p.precio);
            total += p.precio;
        }
        
        System.out.println("Total acumulado: " + total);
        
        
        System.out.println("Carrito con descuento:");
        
        
        
    }
}


