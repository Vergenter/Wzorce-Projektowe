import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class iteratorTest {
    private Container<Integer> container;
    @BeforeEach
    public void prepareContainter(){
        container= new Container<>(1,2,3,4,5,6,7);
    }
    @Test
    public void randomIteratorWorks(){
        Iterator<Integer> iterator= container.getRandomIterator();
        iterator.next();
        while(iterator.hasNext()){
            assertTrue(container.has(iterator.getElement()));
            iterator.next();
        }

    }
    @Test
    public void oddIteratorWorks(){
        Iterator<Integer> iterator= container.getOddIterator();
        iterator.next();
        assertEquals(2,iterator.getElement());
    }
}
