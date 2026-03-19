package models;

import services.DiscountRule;

public class Money {
    private float money;
    private String type;

    public Money(float money){
        this.money = money;
    }

    public Money(float money, String type) {
        this.money = money;
    }

    public float applyDiscount(Cart cart, DiscountRule rule){
        if (rule)
    }


    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
