public class SearchEngine {
    ResultFactory resultFactory;
    Result search(String keyword){
        return resultFactory.getResult(keyword);
    }
    SearchEngine(){
        resultFactory= new ResultFactory();
    }
}
