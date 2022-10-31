import java.util.LinkedList;

public class University {
    private LinkedList<Student> students = new LinkedList<>();
    private LinkedList<Teacher> teachers = new LinkedList<>();
    private LinkedList<Classroom> classrooms = new LinkedList<>();
    private LinkedList<Course> courses = new LinkedList<>();

    University(){
        LinkedList< String[] > studentsXML = Utility.readXML( "student" );
        LinkedList< String[] > teachersXML = Utility.readXML( "teacher" );
        LinkedList< String[] > classroomsXML = Utility.readXML( "classroom" );
        LinkedList< String[] > coursesXML = Utility.readXML( "course" );
        LinkedList< String[] > lecturesXML = Utility.readXML( "lecture" );
        LinkedList< String[] > enrollmentsXML = Utility.readXML( "enrollment" );
        LinkedList< String[] > assignmentsXML = Utility.readXML( "assignment" );
        
        for(String[] stringArray: studentsXML){
            int num = Integer.parseInt(stringArray[1]);
            Student stu = new Student(stringArray[0], num);
            students.add(stu);
        }

        for(String[] stringArray: teachersXML){
            Teacher tea = new Teacher(stringArray[0]);
            teachers.add(tea);
        }

        for(String[] stringArray: classroomsXML){
            Classroom cla = new Classroom(stringArray[0]);
            classrooms.add(cla);
        }

        for(String[] stringArray: coursesXML){
            Course cou = new Course(stringArray[0]);
            courses.add(cou);
        }

        for(String[] stringArray: lecturesXML){
            int slot = Integer.parseInt(stringArray[2]);
            int type = Integer.parseInt(stringArray[3]);
            Lecture lec = new Lecture(stringArray[4], slot, type);

            Classroom cla = Utility.getObject(stringArray[0], classrooms);
            Course cou = Utility.getObject(stringArray[1], courses);

            cla.addLecture(lec);
            cou.addLecture(lec);
            lec.addClassroom(cla);
            lec.addCourse(cou);
        }

        for(String[] stringArray: enrollmentsXML){
            Enrollment enr = new Enrollment(stringArray[2]);

            Student stu = Utility.getObject(stringArray[0], students);
            Course cou = Utility.getObject(stringArray[1], courses);

            stu.addEnrollment(enr);
            cou.addEnrollment(enr);
            enr.addStudent(stu);
            enr.addCourse(cou);
        }

        for(String[] stringArray: assignmentsXML){
            LinkedList<String> grps = new LinkedList<>();
            for(int i = 2; i < stringArray.length; i++){
                grps.add(stringArray[i]);
            }
            Assignment ass = new Assignment(grps);

            Teacher tea = new Teacher(stringArray[0]);
            Course cou = new Course(stringArray[1]);

            tea.addAssignment(ass);
            cou.addAssignment(ass);
            ass.addTeacher(tea);
            ass.addCourse(cou);
        }
    }

    public LinkedList<String> getStudents() {
        LinkedList<String> stu = Utility.toString(students);
        return stu;
    }

    public LinkedList<String> getTeachers() {
        LinkedList<String> tea = Utility.toString(teachers);
        return tea;
    }

    public LinkedList<String> getClassrooms() {
        LinkedList<String> cla = Utility.toString(classrooms);
        return cla;
    }

    public LinkedList<String> getCourses() {
        LinkedList<String> cou = Utility.toString(courses);
        return cou;
    }
}
