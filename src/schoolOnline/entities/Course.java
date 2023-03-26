package schoolOnline.entities;

import schoolOnline.entities.Lecture;
import schoolOnline.entities.Lector;
import schoolOnline.entities.Student;

import java.util.ArrayList;

public class Course {
    public static int courseCount;
    String courseName;
    private int id;
    int studentNumber = Student.studentCount;
    int lectorNumber = Lector.lectorCount;
    int lectureNumber = Lecture.lectureCount;
    ArrayList<Lector> lector;
    ArrayList<Student> student;
    public ArrayList<Lecture> lecture;
    public Course(){
        this.id = ++courseCount;
    }
    public int getId(){
        return this.id;
    }
}
