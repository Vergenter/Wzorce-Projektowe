public abstract class Communicate {
    public final String text;
    final Emitter emitter;
    void emit(){
        emitter.emit(this);
    }
    public Communicate(Emitter emitter, String text){
        this.text=text;
        this.emitter=emitter;
    }
}
