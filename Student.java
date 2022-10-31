import java.util.LinkedList;

public class Student {
    private String name;
    private int nia;
    private LinkedList<Enrollment> enrollments = new LinkedList<>();

    Student(String n, int num){
        name = n;
        nia = num;
    }

    public void addEnrollment(Enrollment e){
        enrollments.add(e);
    }

    public String toString(){
        return name;
    }
}
