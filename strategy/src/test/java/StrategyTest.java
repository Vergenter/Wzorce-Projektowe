import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrategyTest {

    @Test
    public void EvaluationByAchievementsReturnsValue(){
        Student student= new Student("", Arrays.asList(2,3,4),Arrays.asList(""));
        final double expected=1;
        final double actual= new EvaluateByAchievments().evaluate(student);
        assertEquals(expected, actual);

    }
    @Test
    public void EvaluationByNotesReturnsValue(){
        Student student= new Student("", Arrays.asList(2,3,4),Arrays.asList(""));
        final double expected=3;
        final double actual= new EvaluateByNotes().evaluate(student);
        assertEquals(expected, actual);
    }
    @Test
    public void AssignStudentsPositionsAndGetBest() {
        StudentPosisionAssigner posisionAssigner= new StudentPosisionAssigner(new EvaluateByNotes());
        Student studentWithBestGrates=new Student("", Arrays.asList(5,5,5),Arrays.asList(""));
        Student studentWithBestAchievements=new Student("", Arrays.asList(4,4,4),Arrays.asList("","","",""));
        Student worstStudent=new Student("", Arrays.asList(3,3,3),new ArrayList<>());
        List<Student> students=  Arrays.asList(
                studentWithBestGrates,
                studentWithBestAchievements,
                worstStudent
        );
        final Student expected= studentWithBestGrates;
        final Student actual= posisionAssigner.getSortedListOfFromBestStudents(students).get(0);
        assertEquals(studentWithBestGrates, actual);
    }
}