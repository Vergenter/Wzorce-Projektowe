import java.util.List;

public class Student {
    final String name;
    final List<Integer> Notes;
    final List<String> Achievements;
    public Student( String name,List<Integer> Notes,List<String> Achievements){
        this.name=name;
        this.Notes=Notes;
        this.Achievements=Achievements;
    }
}
