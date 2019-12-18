import java.util.Arrays;
import java.util.List;

public class Container<T> {
    List<T> box;
    Container(T... args){
        box= Arrays.asList(args);
    }
    boolean has(T item){
        return box.stream().anyMatch(i->i.equals(item));
    }
    Iterator<T> getRandomIterator(){
        return new RandomIterator<>(box);
    }
    Iterator<T> getOddIterator(){
        return new OddIterator<>(box);
    }
}
