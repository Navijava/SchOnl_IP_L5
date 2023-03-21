package schoolOnline.lecture;

public class Lecture {
    public static int lectureCount;
    private int id;
    public int courseId;
    String name;
    int quantity;
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
}
