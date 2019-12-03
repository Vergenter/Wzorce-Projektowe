
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class compositeTest {
    private Group group;
    int i=0;
    int getUniqueId(){
       return i++;
    }
    @BeforeEach
    public void prepareGroup() {
        group = new Group(
                getUniqueId(),
                Arrays.asList(
                        new Item(getUniqueId(),2),
                        new Item(getUniqueId(),5)
                )
        );
    }
    @Test
    public void getRankingSumsOfItems() {
        final double expected=7;
        final double actual=group.getRating();
        assertEquals(expected,actual);
    }
    @Test
    public void getRankingSumsElementFromNestedGroups() {
        final double expected=7;
        final Group testedGroup = new Group(getUniqueId(),Arrays.asList(group));
        final double actual=testedGroup.getRating();
        assertEquals(expected,actual);
    }
    @Test
    public void getRankingFromEmptyGroup() {
        final double expected=0;
        final Group testedGroup = new Group(getUniqueId(),Arrays.asList());
        final double actual=testedGroup.getRating();
        assertEquals(expected,actual);
    }
    @Test
    public void getRankingFromNestedGroupsAndItems() {
        final double expected=12;
        final Group testedGroup = new Group(getUniqueId(),Arrays.asList(group,new Item(getUniqueId(),5)));
        final double actual=testedGroup.getRating();
        assertEquals(expected,actual);
    }
}
