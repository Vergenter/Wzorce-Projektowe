import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class flyweightTest {
    private SearchEngine searchEngine;
    @BeforeEach
    void prepareSearchEngine(){
        searchEngine = new SearchEngine();
    }
    @Test
    public void createNewResult()
    {
        Result expected = searchEngine.search("Text");
    }
    @Test
    public void searchSameThingTwice()
    {
        Result expected = searchEngine.search("Text");
        Result actual = searchEngine.search("Text");
        assertEquals(expected, actual);
    }
    @Test
    public void searchSameThingTwiceWithIntervalOfOtherSearch() {
        Result expected = searchEngine.search("Text");
        searchEngine.search("OtherText");
        Result actual = searchEngine.search("Text");
        assertEquals(expected, actual);
    }
}
