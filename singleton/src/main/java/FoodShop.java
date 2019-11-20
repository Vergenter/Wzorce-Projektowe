package singleton;

public class FoodShop implements Shop {
    private int cost=5;
    private Boolean PaymentStatus=false;
    public Boolean getPayment(int money) {
        PaymentStatus=money>=cost;
        return PaymentStatus;
    }
    public String getBoughtItem() {
        if(PaymentStatus) {
            return "sausage";
        } else {
            return null;
        }

    }
}
