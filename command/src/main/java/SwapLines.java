import java.util.ArrayList;
import java.util.List;

public class SwapLines extends Command{
    List<String> storedData;
    @Override
    boolean toBeStored() {
        return true;
    }

    @Override
    void execute() {
        storedData= new ArrayList<String>(this.textBox.text);
        this.textBox.text=TextBox.swapLines(this.textBox.text);
    }

    @Override
    void undo() {
        if(storedData==null){
            return;
        }
        this.textBox.text=storedData;
    }
    SwapLines(TextBox textBox,Application application){
        super(textBox,application);
    }
    static SwapLines getSwapLines(TextBox textBox,Application application){
        return new SwapLines(textBox,application);
    }
}
