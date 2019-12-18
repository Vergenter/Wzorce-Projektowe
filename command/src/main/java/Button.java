import java.util.function.BiFunction;

public class Button {
    Application application;
    TextBox textBox;
    BiFunction<TextBox,Application,Command> commandGetter;
    Button(Application application,TextBox textBox,BiFunction< TextBox,Application,Command> commandGetter){
        this.application=application;
        this.textBox=textBox;
        this.commandGetter=commandGetter;
    }
    void onClick(){
        application.onCommand(commandGetter.apply(textBox,application));
    }
}
