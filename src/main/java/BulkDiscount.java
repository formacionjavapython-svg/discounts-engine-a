package main.java;

public class BulkDiscount implements DiscountRule {
    private int minQuantity;
    private double percentage;

    public BulkDiscount(int minQuantity, double percentage) {
        this.minQuantity = minQuantity;
        this.percentage = percentage;
    }

    @Override
    public double apply(Cart cart) {
        double totalBulkDiscount = 0;
        
        for (Item item : cart.getItems()) {
            if (item.getQuantity() >= minQuantity) {
                // El descuento se aplica solo al subtotal de ese producto
                totalBulkDiscount += item.getSubtotal() * percentage;
            }
        }
        
        return totalBulkDiscount;
    }
}