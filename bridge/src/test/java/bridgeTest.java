import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class bridgeTest {
    private Output output;
    @BeforeEach
    public void prepareOutput(){
        output=new Output();
    }
    @Test
    public void EmitVoiceCommand() {
        final String communicateText="Hello, World";
        final String expected=communicateText+'!';
        new Command(new VoiceEmitter(output),communicateText).emit();
        final String actual=output.logBuffer;
        assertEquals(expected,actual);
    }
    @Test
    public void EmitVideoCommand() {
        final String communicateText="Hello, World";
        final String expected=communicateText+'!';
        new Command(new VideoEmitter(output),communicateText).emit();
        final String actual=output.logBuffer;
        assertEquals(expected,actual);
    }
    @Test
    public void EmitVoiceQuestion() {
        final String communicateText="Hello, World";
        final String expected=communicateText+'?';
        new Question(new VideoEmitter(output),communicateText).emit();
        final String actual=output.logBuffer;
        assertEquals(expected,actual);
    }
}
