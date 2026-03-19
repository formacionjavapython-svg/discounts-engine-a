public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

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
    }
}