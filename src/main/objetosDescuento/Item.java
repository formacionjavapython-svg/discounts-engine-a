package main.objetosDescuento;
public class Item {

    private String name;
    private Money precioUnitario;
    private int quantity;

    public Item(String name, Money precioUnitario, int quantity){
        this.name = name;
        this.precioUnitario = precioUnitario;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Money getPrecioUnitario() {
        return precioUnitario;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Calcular subtotal
    public Money calculateSubtotal(){
    return this.precioUnitario.multiply(this.quantity);
        }
}