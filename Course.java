import java.util.LinkedList;

public class Course {
    private String name;
    private LinkedList<Enrollment> enrollments = new LinkedList<>();
    private LinkedList<Assignment> assignments = new LinkedList<>();
    private LinkedList<Lecture> lectures = new LinkedList<>();

    Course(String n){
        name = n;
    }

    public void addEnrollment(Enrollment e){
        enrollments.add(e);
    }

    public void addAssignment(Assignment a){
        assignments.add(a);
    }

    public void addLecture(Lecture l){
        lectures.add(l);
    }

    public String toString(){
        return name;
    }
}
