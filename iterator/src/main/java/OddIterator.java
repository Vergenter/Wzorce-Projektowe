import java.util.ArrayList;
import java.util.List;

public class OddIterator<T> implements Iterator<T>{
    List<T> items;
    int index;
    @Override
    public boolean hasNext() {
        return index+1<items.size();
    }

    @Override
    public void next() throws IndexOutOfBoundsException {
        index++;
        if(index>=items.size()){
            throw new IndexOutOfBoundsException("no more items");
        }

    }

    @Override
    public T getElement() {
        return items.get(index);
    }
    OddIterator(List<T> box){
        int I=0;
        items = new ArrayList<T>(box.size()/2);
        index=-1;
        for (int i=1;i<box.size();i+=2){
            items.add(box.get(i));
        }
    }
}
