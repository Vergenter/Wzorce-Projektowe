import java.util.ArrayList;
import java.util.List;

public class ClientSession {
    public List<String> PurchaseList;
    private static ClientSession instance=null;
    private ClientSession(){
        PurchaseList = new ArrayList<String>();
    }
    static ClientSession getInstance(){
        if(instance==null){
            instance = new ClientSession();
        }
        return instance;
    }
}
