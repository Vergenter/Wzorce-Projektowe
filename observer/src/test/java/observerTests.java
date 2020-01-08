import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class simpleObserver implements Observer{
    boolean updateCalled =false;
    @Override
    public void update(Object object) {
        updateCalled =true;
    }
}

public class observerTests {

    @Test
    void SubjectNotifyObservers(){
        Subject subject = new SubjectWithCriteria();
        simpleObserver observer = new simpleObserver();
        subject.addObserver(observer);
        subject.notifyObservers(new Object());
        final boolean expected=true;
        final boolean actual=observer.updateCalled;
        assertEquals(expected,actual);

    }
    @Test
    void ProductNotifyIfExpirationDateIsLow(){
        ProductWithExpirationDate product= new ProductWithExpirationDate(100,100);
        simpleObserver observer = new simpleObserver();
        product.addObserver(observer);
        product.changePrice(200);
        final boolean expected=true;
        final boolean actual=observer.updateCalled;
        assertEquals(expected,actual);

    }
    @Test
    void ProductDoesNotNotifyIfExpirationDateIsHigh(){
        ProductWithExpirationDate product= new ProductWithExpirationDate(100,1000000);
        Observer observer = new Observer(){
            @Override
            public void update(Object object) {
                fail();
            }
        };
        product.addObserver(observer);
        product.changePrice(200);


    }

}