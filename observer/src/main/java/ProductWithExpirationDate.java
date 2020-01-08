public class ProductWithExpirationDate extends SubjectWithCriteria<ProductWithExpirationDate>{
    static final long WeekInSeconds=7*60*60*24;
    private double Price;
    long ExpirationDateInSeconds;
    void changePrice(double value){
        Price=value;
        this.notifyObservers(this);
    }
    ProductWithExpirationDate(double Price, long ExpiretionDateInSeconds){
        super((ProductWithExpirationDate product)->product.ExpirationDateInSeconds<WeekInSeconds);   //notify if there is less than week
        this.ExpirationDateInSeconds=ExpiretionDateInSeconds;
        this.Price=Price;
    }
}
