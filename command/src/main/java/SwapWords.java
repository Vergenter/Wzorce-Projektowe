import java.util.ArrayList;
import java.util.List;

public class SwapWords extends Command{
    List<String> storedData;
    @Override
    boolean toBeStored() {
        return true;
    }

    @Override
    void execute() {
        storedData= new ArrayList<String>(this.textBox.text);
        this.textBox.text=TextBox.swapWords(this.textBox.text);
    }

    @Override
    void undo() {
        if(storedData==null){
            return;
        }
        this.textBox.text=storedData;
    }
    SwapWords(TextBox textBox,Application application){
        super(textBox,application);
    }
    static SwapWords getSwapWords(TextBox textBox,Application application){
        return new SwapWords(textBox,application);
    }
}