public abstract class Command {
    protected TextBox textBox;
    protected Application application;
    abstract boolean toBeStored();
    abstract void execute();
    abstract void undo();
    Command(TextBox textBox,Application application){
        this.textBox=textBox;
        this.application=application;
    }
}
