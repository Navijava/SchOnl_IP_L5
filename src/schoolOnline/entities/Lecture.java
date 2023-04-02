package schoolOnline.entities;

public class Lecture {
    private static int lectureCount;
    private int id;
    private int courseId;
    private String name;
    public Lecture(){
        this.id = ++lectureCount;
    }
    public Lecture(int courseId){
        this.courseId = courseId;
        this.id = ++lectureCount;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public static int getLectureCount(){
        return lectureCount;
    }
    public int getCourseId(){
        return courseId;
    }

    public String toString(){
        return this.name;
    }
}
