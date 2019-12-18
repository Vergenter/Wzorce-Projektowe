import java.util.Stack;

public class CommandHistory {
    Stack<Command> history;
    Command pop(){
        if(history.empty()) {
            return null;
        }
        return history.pop();
    }
    void push(Command command){
        history.push(command);
    }
    CommandHistory(){
        history = new Stack<>();
    }
}
