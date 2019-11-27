import java.util.List;

public class Food implements cloneable {
    final public List<Nutrient> Nutrients;
    Food(List<Nutrient> nutrients){
        this.Nutrients=nutrients;
    }
    public Food clone() {
        return new Food(Nutrients); //shallow copy
    }
}
