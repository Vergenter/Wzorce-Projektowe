public class Command extends Communicate{
    Command(Emitter emitter, String text){
        super(emitter,text.concat("!"));
    }
}
