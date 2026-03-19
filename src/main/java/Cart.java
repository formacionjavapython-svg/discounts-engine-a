import java.util.ArrayList;
import java.util.List;

/**
 * Cart - Carrito de compras
 * Contiene una lista de items y permite agregar, remover y calcular total 
 */
public class Cart {
    private final List<Item> items;
    
    public Cart() {
        this.items = new ArrayList<>(); 
    }
    
    /**
     * Agrega un item al carrito
     */
    public void addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("El item no puede ser null");
        }
        items.add(item);
    }
    
    /**
     * Remueve un item específico del carrito
     */
    public void removeItem(Item item) {
        items.remove(item);
    }
    
    /**
     * Calcula el total del carrito sumando los subtotales de todos los items
     */
    public Money getTotal() {
        if (items.isEmpty()) {
            // Si no hay items, devolvemos 0 en MXN (por defecto)
            return new Money(0, "MXN");
        }
        
        String currency = items.get(0).getUnitPrice().getCurrency();
        int totalAmount = 0;
        
        // Sumamos todos los subtotales
        for (Item item : items) {
            totalAmount += item.getSubtotal().getAmount();
        }
        
        return new Money(totalAmount, currency);
    }
    
    /**
     * Obtiene la lista de items 
     */
    public List<Item> getItems() {
        return new ArrayList<>(items); // Devolvemos copia
    }
    
    /**
     * Vacía el carrito
     */
    public void clear() {
        items.clear();
    }
    
    /**
     * Obtiene la cantidad de items diferentes en el carrito
     */
    public int getItemCount() {
        return items.size();
    }

}
