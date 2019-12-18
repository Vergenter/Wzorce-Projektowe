import java.util.Arrays;
import java.util.List;

public class Application {
    CommandHistory history;
    TextBox textBox;
    List<Button> buttons;
    void onCommand(Command command){
        if(command.toBeStored()){
            history.push(command);
        }
        command.execute();
    }
    Application(){
        history = new CommandHistory();
        textBox = new TextBox("Lorem ipsum","Doret Lorem");
        buttons = Arrays.asList(
                new Button(this,textBox,SwapLetters::getSwapLetters),
                new Button(this,textBox,SwapLines::getSwapLines),
                new Button(this,textBox,SwapWords::getSwapWords),
                new Button(this,textBox,Undo::getUndo)
        );
    }
    void undo(){
        Command command= history.pop();
        if(command==null){
            return;
        }
        command.undo();
    }
}
