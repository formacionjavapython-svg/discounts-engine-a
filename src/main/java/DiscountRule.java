import discount.BulkDiscount;
import discount.CouponDiscount;
import discount.thresholdDiscount;


public class DiscountRule {

    List<DiscountRule> rules = Arrays.asList(
        new ThresholdDiscount(5000, 0.10),
        new CouponDiscount(),
        new BulkDiscount(3,0.05)
    );
    
}
