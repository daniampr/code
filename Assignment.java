import java.util.LinkedList;

public class Assignment {
    private LinkedList<String> groups = new LinkedList<>();
    private Teacher teacher;
    private Course course;

    Assignment(LinkedList<String> g){
        groups = g;
    }

    public void addTeacher(Teacher t){
        teacher = t;
    }

    public void addCourse(Course c){
        course = c;
    }
}
