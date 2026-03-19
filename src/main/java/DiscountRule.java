public interface DiscountRule {
    Money apply(Cart cart);
}