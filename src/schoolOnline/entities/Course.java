package schoolOnline.entities;

import schoolOnline.entities.Lecture;
import schoolOnline.entities.Lector;
import schoolOnline.entities.Student;
import schoolOnline.repositories.LectureRepository;

import java.util.ArrayList;

public class Course {
    private static int courseCount;
    private String courseName;
    private int id;
    private int studentNumber = Student.getStudentCount();
    private int lectorNumber = Lector.getLectorCount();
    private int lectureNumber = Lecture.getLectureCount();
    private ArrayList<Lector> lector;
    private ArrayList<Student> student;
    private ArrayList<Lecture> lecture;
    private LectureRepository lectureRepository;
    public Course(){
        this.id = ++courseCount;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public static int getCourseCount(){
        return courseCount;
    }
    public void setLectureRepository(LectureRepository lectureRepository){
        this.lectureRepository = lectureRepository;
    }
    public LectureRepository getLectureRepository(){
        return lectureRepository;
    }
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    public String getCourseName(){
        return courseName;
    }

    public String toString(){
        return "Course id is " + id + ".";
    }
}
