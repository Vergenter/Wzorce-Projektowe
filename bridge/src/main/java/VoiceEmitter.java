public class VoiceEmitter implements Emitter{
    final Output output;
    public Communicate readText(Communicate communicate){
        // do things
        output.log(communicate);
        return communicate;
    }
    public void emit(Communicate communicate) {
        readText(communicate);
    }
    public VoiceEmitter(Output output){
        this.output=output;
    }
}