package controllers;

import ioc.Ioc;
import models.Item;
import models.Money;

import java.util.Scanner;

public class MotorDescuento {
    public void agregarItems(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(" - Nombre del producto > ");
            String name = sc.nextLine();
            System.out.println(" - Precio en MXN >");
            float price = sc.nextFloat();
            Money priceForItem = new Money(price, "MXN");
            System.out.println(" - Cantidad de articulo a comprar >");
            float quantity = sc.nextFloat();
            Item item = new Item(name, priceForItem, quantity);
            Ioc.cartSale.addItem(item);
            System.out.println(" Agregar un nuevo item de compra: y/n");
            if (sc.next().equals("n")) {
                break;
            }
        }
        sc.close();
    }

    public void eliminarItem(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" - Nombre del producto a eliminar > ");
        String name = sc.nextLine();
        for( Item item : Ioc.cartSale.getItems()){
            if (name.equals(item.getName())){
                Ioc.cartSale.removeItem(item);
            }
        }
        sc.close();
    }

    public void makeSale(){
        Money descuentoThreshold = Ioc.rules.get("threshold").apply(Ioc.cartSale);
        Ioc.cartSale.applyDiscount(descuentoThreshold);
        System.out.println("Total a pagar con descuento: "+ Ioc.cartSale.getMoney());
        System.out.println("Descuento aplicado: "+descuentoThreshold.getMoney());
    }
}
