public class Item implements IItem {
    public final int Id;
    public final double rate;
    public Item(int Id,double rate){
        this.Id=Id;
        this.rate=rate;
    }
    public double getRating() {
        return rate;
    }
    @Override
    public int getId() {
        return this.Id;
    }
}
