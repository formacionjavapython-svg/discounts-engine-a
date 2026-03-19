package main.objetosDescuento;
import java.util.ArrayList;
import java.util.List;

class Cart {

private List<Item> items = new ArrayList<>();

public void addItem(Item item){
    items.add(item);
}
public void deleteItem(Item item) {
    items.remove(item);
}
public Money calculateTotal(){
    Money total= new Money(0,"MXN");
    for (Item a: Items) {
        Money subtotalDelItem= a.calcularSubtotal();
        total = total.sumar(subtotalDelItem)
    }
    return total;
}
}
