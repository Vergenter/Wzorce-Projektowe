import java.util.HashMap;
import java.util.Map;

public class MossadInterceptor implements IReceiver {
    Map<String,Integer> UserMaleficence;
    private final IReceiver Receiver;
    MossadInterceptor(IReceiver iReceiver){
        UserMaleficence = new HashMap<String, Integer>();
        this.Receiver=iReceiver;
    }
    private void noteUserMaleficence(String userId){
        if(UserMaleficence.containsKey(userId)){
            UserMaleficence.put(userId,UserMaleficence.get(userId)+1);
        } else {
            UserMaleficence.put(userId,1);
        }
    }
    public void ReceiveMessage(Message message) {
        String Nword = "antisemitism";
        if(message.MessageContent.contains(Nword)){
            noteUserMaleficence(message.SenderIp);
        }
        Receiver.ReceiveMessage(message);
    }
}
