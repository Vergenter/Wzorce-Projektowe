import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class commandTest {
    @Test
    public void TestTextBoxSwapLines() {
        List<String> start = Arrays.asList("Raz Dwa","Trzy Cztery");
        final List<String> expected=Arrays.asList("Trzy Cztery","Raz Dwa");
        final List<String> actual=TextBox.swapLines(start);


        for(int i=0;i<expected.size();i++){
            assertTrue(expected.get(i).equals(actual.get(i)));
        }

    }
    @Test
    public void TestTextBoxSwapWords() {
        List<String> start = Arrays.asList("Raz Dwa","Trzy Cztery");
        final List<String> actual=TextBox.swapWords(start);
        final List<String> expected=Arrays.asList("Dwa Raz","Cztery Trzy");

        for(int i=0;i<expected.size();i++){
            assertTrue(expected.get(i).equals(actual.get(i)));
        }
    }
    @Test
    public void TestTextBoxSwapLetters() {
        List<String> start = Arrays.asList("Raz Dwa","Trzy Cztery");
        final List<String> actual=TextBox.swapLetters(start);
        final List<String> expected=Arrays.asList("aR zwDa","rTyzC tzrey");

        for(int i=0;i<expected.size();i++){
            assertTrue(expected.get(i).equals(actual.get(i)));
        }
    }
    @Test
    public void TestCommandEffect() {
        Application app = new Application();
        final List<String> expected=Arrays.asList("Doret Lorem","Lorem ipsum");
        app.buttons.get(1).onClick();
        final List<String> actual=app.textBox.text;

        for(int i=0;i<expected.size();i++){
            assertTrue(expected.get(i).equals(actual.get(i)));
        }
    }
    @Test
    public void TestCommandEffectAndUndo() {
        Application app = new Application();
        final List<String> expected=Arrays.asList("Doret Lorem","Lorem ipsum");
        app.buttons.get(1).onClick();
        final List<String> actual=app.textBox.text;
        for(int i=0;i<expected.size();i++){
            assertTrue(expected.get(i).equals(actual.get(i)));
        }
        app.buttons.get(3).onClick();
        final List<String> Newexpected=Arrays.asList("Lorem ipsum","Doret Lorem");
        final List<String> Newactual=app.textBox.text;
        for(int i=0;i<Newexpected.size();i++){
            assertTrue(Newexpected.get(i).equals(Newactual.get(i)));
        }
    }
}
