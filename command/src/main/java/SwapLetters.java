import java.util.ArrayList;
import java.util.List;

public class SwapLetters extends Command{
    List<String> storedData;
    @Override
    boolean toBeStored() {
        return true;
    }

    @Override
    void execute() {
        storedData= new ArrayList<String>(this.textBox.text);
        this.textBox.text=TextBox.swapLetters(this.textBox.text);
    }

    @Override
    void undo() {
        if(storedData==null){
            return;
        }
        this.textBox.text=storedData;
    }
    SwapLetters(TextBox textBox,Application application){
        super(textBox,application);
    }
    static SwapLetters getSwapLetters(TextBox textBox,Application application){
        return new SwapLetters(textBox,application);
    }
}
