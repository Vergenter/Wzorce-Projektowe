import java.util.List;

public class Undo extends Command{
    List<String> storedData;
    @Override
    boolean toBeStored() {
        return false;
    }

    @Override
    void execute() {
        this.application.undo();
    }

    @Override
    void undo() {
        return;
    }

    Undo(TextBox textBox,Application application){
        super(textBox,application);
    }
    static Undo getUndo(TextBox textBox,Application application){
        return new Undo(textBox,application);
    }
}
