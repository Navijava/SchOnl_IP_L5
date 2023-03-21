package schoolOnline.courses;

import schoolOnline.lecture.Lecture;
import schoolOnline.lector.Lector;
import schoolOnline.student.Student;

import java.util.ArrayList;

public class Course {
    static int courseCount;
    String courseName;
    private int id;
    int studentNumber = Student.studentCount;
    int lectorNumber = Lector.lectorCount;
    int lectureNumber = Lecture.lectureCount;
    ArrayList<Lector> lector;
    ArrayList<Student> student;
    ArrayList<Lecture> lecture;
    Course(){
        this.id = ++courseCount;
    }
    public int getId(){
        return this.id;
    }
}
