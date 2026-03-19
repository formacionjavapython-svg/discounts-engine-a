package models;

public class Money {
    private float money;
    private String type;

    public Money() {}


    public Money(float money, String type) {
        this.money = money;
    }

    public Money sumarMoney(Money moneyMore){
        return new Money(this.money + moneyMore.getMoney(), this.getType());
    }

    public Money restarMoney(Money moneyMore){
        return new Money(this.money - moneyMore.getMoney(), this.getType());
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
