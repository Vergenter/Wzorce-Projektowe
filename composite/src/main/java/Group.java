import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class Group implements IItem{
    public final Map<Integer,IItem> Items;
    public final int Id;
    public Group(int Id, Collection<Item> items){
        this.Id=Id;
        this.Items=items.stream().collect(Collectors.toMap(IItem::getId ,item->item));
    }
    public double getRating() {
        return Items.values().stream().map(item->item.getRating()).reduce(0d, (sum,element)->sum+element);
    }
    @Override
    public int getId() {
        return this.Id;
    }
}
