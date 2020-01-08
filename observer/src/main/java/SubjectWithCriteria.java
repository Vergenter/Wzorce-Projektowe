import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class SubjectWithCriteria<T> implements Subject<T>{
    private List<Observer<T>> observerList;
    private List<Function<T,Boolean>> Criterias;


    public SubjectWithCriteria(Function<T,Boolean>... criteria){
        Criterias= Arrays.asList(criteria);
        observerList = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer<T> observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer<T> observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(T t) {
        if(Criterias.stream().anyMatch(x->!x.apply(t))){
            return;
        }
        observerList.stream().forEach(ob->ob.update(t));
    }
}
