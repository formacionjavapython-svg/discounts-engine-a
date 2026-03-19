package rules;
import domains.*;

public interface DiscountRule {
    Money apply(Cart cart);
}
