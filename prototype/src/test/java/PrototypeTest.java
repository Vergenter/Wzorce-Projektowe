import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PrototypeTest {
    private Shop shop;

    @BeforeEach
    public void prepareShop() {
        shop = new Shop(
                Arrays.asList(new Food(Arrays.asList(new Nutrient("carbohydrates"))))
        );
    }

    @Test
    public void clonedObjectsAreDiffrent() {
        Shop myShop=this.shop.clone();
        assertNotEquals(myShop,this.shop);
    }
    @Test
    public void deepCopyNestedObject() {
        Shop myShop=this.shop.clone();
        assertNotEquals(myShop,this.shop);
        assertNotEquals(myShop.foodList,this.shop.foodList);
    }
    @Test
    public void shallowCopyDeepestObject() {
        Shop myShop=this.shop.clone();
        assertNotEquals(myShop,this.shop);
        assertNotEquals(myShop.foodList,this.shop.foodList);
        assertTrue(myShop.foodList.get(0).Nutrients.stream().filter(this.shop.foodList.get(0).Nutrients::contains).count()>0);
    }
}