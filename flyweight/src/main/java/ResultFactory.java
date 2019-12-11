import java.util.HashMap;
import java.util.Map;

public class ResultFactory {
    private Map<String,Result> memory;
    ResultFactory(){
        memory= new HashMap<String,Result>();
    }
    Result getResult(String keyword){
        Result result = memory.get(keyword);
        if(result!=null){
            return result;
        }
        result = new Result(keyword);
        memory.put(keyword,result);
        return result;
    }
}
