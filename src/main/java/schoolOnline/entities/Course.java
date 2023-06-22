package schoolOnline.entities;

import schoolOnline.repositories.LectureRepository;
import schoolOnline.repositories.PersonRepository;
import schoolOnline.repositories.StudentRepository;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Comparable<Course>, Serializable {
    public Course(){this.id = ++courseCount;}
    public Course(String name){
        this.id = ++courseCount;
        this.name = name;
        this.lector = new Lector("BigBoss");
        this.lectureRepository = new LectureRepository();
        this.studentRepository = new StudentRepository();
    }
    public Course(int id, String name){
        this.id = ++courseCount;
        this.name = name;
        this.lector = new Lector("BigBoss");
        this.lectureRepository = new LectureRepository();
        this.studentRepository = new StudentRepository();
    }
    public Course(int id, String name, int studentNumber){
        ++courseCount;
        this.id = id;
        this.name = name;
        this.studentNumber = studentNumber;
        this.lectureRepository = new LectureRepository();
        this.studentRepository = new StudentRepository();
    }

    private Integer id;
    public String commonName;
    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return id;
    }

    private static int courseCount;
    private String name;
    private int studentNumber = Student.getStudentCount();
    private int lectorNumber = Lector.getLectorCount();
    private int lectureNumber = Lecture.getLectureCount();
    private Lector lector;
    public Lector getLector(){
        return this.lector;
    }
    private ArrayList<Lector> lectors;
    public void setLectors(){
        this.lectors = new ArrayList<>();
    }
    public ArrayList<Lector> getLectors(){
        return this.lectors;
    }
    private ArrayList<Student> student;
    private ArrayList<Lecture> lecture;
    private LectureRepository lectureRepository;
    private StudentRepository studentRepository;
    public static int getCourseCount(){
        return courseCount;
    }
    public void setLectureRepository(LectureRepository lectureRepository){
        this.lectureRepository = lectureRepository;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public LectureRepository getLectureRepository(){
        return lectureRepository;
    }
    public StudentRepository getStudentRepository(){
        return this.studentRepository;
    }
     public String toString(){
         //return "Course id is " + id + ".";
         return "\nCourse name is " + name;
    }

    @Override
    public int compareTo(Course o) {
        return this.name.compareTo(o.name);
    }
}
