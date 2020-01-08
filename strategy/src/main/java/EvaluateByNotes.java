public class EvaluateByNotes implements  EvaluateStudent{
    @Override
    public double evaluate(Student student) {
        return student.Notes.stream()
                .mapToInt(i->i)
                .average()
                .getAsDouble();
    }
}
