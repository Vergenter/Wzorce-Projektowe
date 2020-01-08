public class EvaluateByAchievments implements  EvaluateStudent{
    @Override
    public double evaluate(Student student) {
        return student.Achievements.size();
    }
}
