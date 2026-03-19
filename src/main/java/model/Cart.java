package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// clase que representa al carrrito
public class Cart {
    private List<Item> items = new ArrayList<>(); // lista de articulos
    private String appliedCoupon; // cupon a aplicar

    public void setApplyCoupon(String code) {
        this.appliedCoupon = code;
    }

    public String getAppliedCoupon() {
        return appliedCoupon;
    }

    // añade un articulo si ya existe aumenta la cantidad
   public void addItem(Item item) {
       this.items.stream()
               .filter(i -> i.getName().equals(item.getName()))
               .findFirst()
               .ifPresentOrElse(
                       i -> i.setQuantity(i.getQuantity() + item.getQuantity()),
                       () -> this.items.add(item)
               );
   }

   // elimina un articulo
    public void deleteItem(Item item) {
        this.items.removeIf(i -> i.getName().equals(item.getName()));
    }

    // calcula el total del carrito
    public Money calculateTotal() {
       if (this.items.isEmpty()) {
           return new Money(BigDecimal.ZERO, "MXN");
       }

       return this.items.stream()
               .map(Item::calculateSubtotal)
               .reduce(new Money(BigDecimal.ZERO, "MXN"), Money::add);

    }

}
