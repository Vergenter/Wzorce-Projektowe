import java.util.List;
import java.util.stream.Collectors;

public class Shop implements cloneable {
    final public List<Food> foodList;
    Shop(List<Food> foodList){
        this.foodList=foodList;
    }
    public Shop clone() {
        return new Shop(foodList.stream().map(Food::clone).collect(Collectors.toList()));
    }
}
