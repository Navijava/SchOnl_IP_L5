package schoolOnline.entities;

import schoolOnline.repositories.LectureRepository;

import java.util.ArrayList;

public class Course implements Comparable<Course> {
    public Course(){this.id = ++courseCount;}
    public Course(String name){
        this.id = ++courseCount;
        this.name = name;
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
    private ArrayList<Lector> lector;
    private ArrayList<Student> student;
    private ArrayList<Lecture> lecture;
    private LectureRepository lectureRepository;
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
     public String toString(){
         //return "Course id is " + id + ".";
         return "\nCourse name is " + name;
    }

    @Override
    public int compareTo(Course o) {
        return this.name.compareTo(o.name);
    }
}
