package src.main.java;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


/**
 * Clase principal para la practica de Java
 * */

public class Main {

	public static void main(String[] args){
		//Metodo para imprimir Hello World
		System.out.println("Hello world!!");

		Cart carrito = new Cart();

		carrito.agregarItem(new Item("Termo", new Money(BigDecimal.valueOf(450),"MXN"),1));

		carrito.agregarItem(new Item("TV", new Money(BigDecimal.valueOf(7000),"MXN"),2));

		List<DiscountRule> rules = Arrays.asList(
				new ThresholdDiscount(BigDecimal.valueOf(5000), BigDecimal.valueOf(0.10)),
				new CouponDiscount("SUPER2024")
		);

		Money descuentoTotal = new Money(BigDecimal.valueOf(0), "MXN");

		for (DiscountRule rule : rules) {
			descuentoTotal = descuentoTotal.sumarDinero(rule.apply(carrito));
		}

		BigDecimal totalFinal = carrito.calcularTotal().getMonto()
				.subtract(descuentoTotal.getMonto());

		System.out.println("Subtotal: " + carrito.calcularTotal());
		System.out.println("Descuento total: " + descuentoTotal);
		System.out.println("Total final: "+totalFinal+" MXN");
	}

}
