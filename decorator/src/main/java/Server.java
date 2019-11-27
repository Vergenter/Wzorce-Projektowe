import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Server implements IReceiver {
    private List<Message> messageLog;
    Server(){
        messageLog=new ArrayList<Message>();
    }
    public List<Message> getLog(){
        return messageLog;
    }
    public void ReceiveMessage(Message message) {
        messageLog.add(message);
    }
}
