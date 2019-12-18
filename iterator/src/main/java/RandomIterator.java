import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class RandomIterator<T> implements Iterator<T> {
    Map<Integer,T> items;
    T Element;
    public boolean hasNext() {
        return !items.isEmpty();
    }

    public void next() throws IndexOutOfBoundsException {
        if(items.isEmpty()){
            throw new IndexOutOfBoundsException("no more items");
        }
        List<Integer> valuesList = new ArrayList<Integer>(items.keySet());
        int key = valuesList.get(new Random().nextInt(valuesList.size()));
        Element = items.get(key);
        items.remove(key);
    }

    public T getElement() {
        return this.Element;
    }
    RandomIterator(List<T> box){
        items = IntStream.range(0, box.size()).boxed().collect(Collectors.toMap(i -> i,box::get ));
    }
}
