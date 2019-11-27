public class CarShop implements Shop {
    private int cost=160000;
    private Boolean PaymentStatus=false;
    public Boolean getPayment(int money) {
        PaymentStatus=money>=cost;
        return PaymentStatus;
    }
    public String getBoughtItem() {
        if(PaymentStatus) {
            return "Aston Martin DB9";
        } else {
            return null;
        }
    }
}
