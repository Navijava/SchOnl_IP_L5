package schoolOnline.entities;

public class Lecture extends Academy{
    private static int lectureCount;
    private int courseId;
    public Lecture(){
        this.id = ++lectureCount;
    }
    public Lecture(int courseId){
        this.courseId = courseId;
        this.id = ++lectureCount;
    }
    public static int getLectureCount(){
        return lectureCount;
    }
    public int getCourseId(){
        return courseId;
    }

    public String toString(){
        return name;
    }
}
