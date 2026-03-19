import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        System.out.println("///////////////////////////////////////////////////////////////////////////////");
        System.out.println("=== Motor de Descuentos ===\n");
        
        // 1. Crear algunos precios (Money)
        Money precioLaptop = new Money(15000, "MXN");
        Money precioMouse = new Money(500, "MXN");
        Money precioTeclado = new Money(800, "MXN");
        
        // 2. Crear items (Productos con cantidad)
        Item laptop = new Item("Laptop Gamer", precioLaptop, 1);
        Item mouse = new Item("Mouse RGB", precioMouse, 1);
        Item mouse2 = new Item("Mouse RGB", precioMouse, 1);
        Item teclado = new Item("Teclado Mecanico", precioTeclado, 1);
        
        // 3. Crear carrito y agregar items
        Cart cart = new Cart();
        cart.addItem(laptop);
        cart.addItem(mouse);
        cart.addItem(mouse2);
        cart.addItem(teclado);
        
        // 4. Mostrar información
        System.out.println("Productos en el carrito:");
        for (Item item : cart.getItems()) {
            System.out.println("  - " + item.getName() + 
                             " x" + item.getQuantity() + 
                             " = $" + item.getSubtotal().getAmount() + 
                             " " + item.getSubtotal().getCurrency());
        }
        
        System.out.println("\nTotal del carrito: $" + 
                         cart.getTotal().getAmount() + " " + 
                         cart.getTotal().getCurrency());
        
        // 5. Prueba removiendo un item
        System.out.println("\n--- Removiendo el mouse ---");
        cart.removeItem(mouse);
        System.out.println("Items en carrito ahora: " + cart.getItemCount());
        System.out.println("Nuevo total: $" + cart.getTotal().getAmount() + 
                         " " + cart.getTotal().getCurrency());

        System.out.println("///////////////////////////////////////////////////////////////////////////////");
        System.out.println("=== Motor de Descuentos - Reglas de descuento ===\n");
        
        // 1. Se crea un carrito con productos
        Cart cart2 = new Cart();
        
        // Agregamos productos para que el total sea mayor a $5000
        cart2.addItem(new Item("Laptop", new Money(15000, "MXN"), 1));
        cart2.addItem(new Item("Mouse", new Money(500, "MXN"), 2));
        cart2.addItem(new Item("Teclado", new Money(800, "MXN"), 1));
        
        System.out.println("Carrito original:");
        System.out.println(cart2.getTotal().getAmount() + " " + cart2.getTotal().getCurrency());
        
        // 2. Se crean las reglas de descuento ( 10% si compra mas de $5000 y cupon de descuento $200 pesitos)
        List<DiscountRule> rules = Arrays.asList(
            new ThresholdDiscount(5000, 0.10),  
            new CouponDiscount(200)              
        );
        
        // 3. Se aplica una cadena de reglas 
        System.out.println("\n=== Aplicando descuentos ===");
        
        Money descuentoTotal = new Money(0, "MXN");
        
        for (DiscountRule rule : rules) {
            Money descuento = rule.apply(cart2);
            System.out.println("Regla: " + rule.getClass().getSimpleName() + 
                             " - Descuento: $" + descuento.getAmount());
            
           
            descuentoTotal = descuentoTotal.add(descuento);
        }
        
        // 4. Se muestran resultados finales
        System.out.println("\n=== Resultados finales ===");
        System.out.println("Total original: $" + cart2.getTotal().getAmount());
        System.out.println("Descuento total: $" + descuentoTotal.getAmount());
        
        Money totalFinal = cart2.getTotal().subtract(descuentoTotal);
        System.out.println("Total a pagar: $" + totalFinal.getAmount());

        System.out.println("///////////////////////////////////////////////////////////////////////////////");

        System.out.println("=== Motor de Descuentos - con seguridad y eso de secretos ===\n");
        
        // se crea el carro
        Cart cart3 = new Cart();
        cart3.addItem(new Item("Laptop", new Money(15000, "MXN"), 1));
        cart3.addItem(new Item("Mouse", new Money(500, "MXN"), 2));
        cart3.addItem(new Item("Teclado", new Money(800, "MXN"), 1));
        
        System.out.println("Carrito original: $" + cart3.getTotal().getAmount());
        
        // Se crean las reglas
        List<DiscountRule> rules2 = Arrays.asList( //
            new ThresholdDiscount(5000, 0.10),
            new CouponDiscount(200) 
        );        
        // Se aplican descuentos
        Money descuentoTotal2 = new Money(0, "MXN"); //
        
        System.out.println("\n=== Aplicando descuentos ===");
        for (DiscountRule rule : rules2) {
            Money descuento = rule.apply(cart3);
            System.out.println(rule.getClass().getSimpleName() + 
                             ": $" + descuento.getAmount());
            descuentoTotal2 = descuentoTotal2.add(descuento);
        }
        
        System.out.println("\n=== Resultados ===");
        System.out.println("Total original: $" + cart3.getTotal().getAmount());
        System.out.println("Descuento total: $" + descuentoTotal2.getAmount());
        
        Money totalFinal2 = cart3.getTotal().subtract(descuentoTotal2); //
        System.out.println("Total a pagar: $" + totalFinal2.getAmount());
        
        // Prueba la validacion del cupon 
        System.out.println("\n=== Probando validacion de cupones ===");
        
        CouponDiscount cuponRule = (CouponDiscount) rules2.get(1);
                
        // Probando con cupón incorrecto (se probo en locar la validacion de correcto
        // aqui para el repositorio remoto solo se muestra este para no revelar el correcto)
        String cuponIncorrecto = "OTRO2024";
        boolean resultado2 = cuponRule.validarCupon(cuponIncorrecto);
        System.out.println("Cupon '" + cuponIncorrecto + "' = " + resultado2);
        
       
    }
}