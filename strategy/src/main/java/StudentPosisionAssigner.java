import java.util.ArrayList;
import java.util.List;

public class StudentPosisionAssigner {
    EvaluateStudent evaluator;
    public StudentPosisionAssigner(EvaluateStudent evaluator){
        this.evaluator=evaluator;
    }
    List<Student> getSortedListOfFromBestStudents(List<Student> students){
        List<Student> sortedList = new ArrayList<>(students);
        sortedList.sort((Student s1, Student s2) -> (int)Math.signum(evaluator.evaluate(s2)-evaluator.evaluate(s1)));
        return sortedList;
    }
}
