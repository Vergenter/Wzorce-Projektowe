import java.lang.reflect.Field;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    public SingletonTest() {
    }

    @Test
    public void createSingleton() {
        try {
            Field field = ClientSession.class.getDeclaredField("instance");
            field.setAccessible(true);
            Assumptions.assumeTrue(field.get((Object)null) == null, "There is previous instance of Singleton");
        } catch (NoSuchFieldException e) {
            Assertions.fail(e);
        } catch (SecurityException e) {
            Assertions.fail(e);
        } catch (IllegalAccessException e) {
            Assertions.fail(e);
        }

        ClientSession.getInstance();

        try {
            Field field = ClientSession.class.getDeclaredField("instance");
            field.setAccessible(true);
            Assertions.assertNotEquals((Object)null, field.get((Object)null));
        } catch (Exception e) {
            Assertions.fail(e);
        }

    }

    @Test
    public void thereIsOnlyOneSingleton() {
        ClientSession singleton = ClientSession.getInstance();
        Assertions.assertEquals(true, singleton.PurchaseList.isEmpty(), "There is something in list!?");
        Market market = new Market();
        market.bidFood(6);
        Assertions.assertNotEquals(true, market.session.PurchaseList.isEmpty());
        Assertions.assertNotEquals(true, singleton.PurchaseList.isEmpty());
    }

    @Test
    public void holdsValueBetweenTests() {
        ClientSession singleton = ClientSession.getInstance();
        Assertions.assertNotEquals(true, singleton.PurchaseList.isEmpty());
    }

    @Test
    public void isNotDestroyedWhenOwningClassIs() {
        new Market();

        try {
            Field field = ClientSession.class.getDeclaredField("instance");
            field.setAccessible(true);
            Assertions.assertNotEquals((Object)null, field.get((Object)null));
        } catch (Exception e) {
            Assertions.fail(e);
        }

    }
}
