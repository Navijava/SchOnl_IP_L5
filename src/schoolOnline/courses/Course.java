package schoolOnline.courses;

import schoolOnline.lection.Lection;
import schoolOnline.lector.Lector;
import schoolOnline.student.Student;

import java.util.ArrayList;

public class Course {
    static int courseCount;
    String courseName;
    private int id;
    int studentNumber = Student.studentCount;
    int lectorNumber = Lector.lectorCount;
    int lectionNumber = Lection.lectionCount;
    ArrayList<Lector> lector;
    ArrayList<Student> student;
    ArrayList<Lection> lection;
    Course(){
        courseCount++;
    }
}
