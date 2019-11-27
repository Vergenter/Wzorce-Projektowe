import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuilderTest {
    public BuilderTest() {
    }

    @Test
    public void builderGivesUser() {
        ImmutableUser user = null;
        user = (new ImmutableUser.Builder()).build();
        Assertions.assertNotEquals((Object)null, user);
    }

    @Test
    public void BuilderSetsValues() {
        String login = "login";
        ImmutableUser user = (new ImmutableUser.Builder()).login("login").build();
        Assertions.assertEquals("login", user.login);
    }
}