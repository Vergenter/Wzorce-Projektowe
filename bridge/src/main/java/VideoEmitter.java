public class VideoEmitter implements Emitter{
    final Output output;
    public Communicate streamVideo(Communicate communicate){
        // do things
        output.log(communicate);
        return communicate;
    }
    public void emit(Communicate communicate) {
        streamVideo(communicate);
    }
    public VideoEmitter(Output output){
        this.output=output;
    }
}
