import java.util.LinkedList;

public class Classroom {
    private String code;
    private LinkedList<Lecture> lectures = new LinkedList<>();

    Classroom(String c){
        code = c;
    }

    public void addLecture(Lecture l){
        lectures.add(l);
    }

    public String toString(){
        String c = "" + code;
        return c;
    }
}
