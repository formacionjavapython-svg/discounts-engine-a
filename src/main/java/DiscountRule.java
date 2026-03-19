package main.java;

public interface DiscountRule {
    double apply(Cart cart);
}