import java.util.LinkedList;

public class Teacher {
    private String name;
    private LinkedList<Assignment> assignments = new LinkedList<>();

    Teacher(String n){
        name = n;
    }

    public void addAssignment(Assignment a){
        assignments.add(a);
    }

    public String toString(){
        return name;
    }
}
