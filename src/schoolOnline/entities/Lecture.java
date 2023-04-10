package schoolOnline.entities;

public class Lecture extends Academy{
    private static int lectureCount;
    private String name;
    private String description;
    private int courseId;
    private int personId;
    private Lector lector;

    public Lecture(){
        this.id = ++lectureCount;
    }
    public Lecture(int courseId){
        this.courseId = courseId;
        this.id = ++lectureCount;
        this.lector = new Lector(Role.LECTOR, courseId, id);
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }

    public static int getLectureCount(){
        return lectureCount;
    }
    public int getCourseId(){
        return courseId;
    }
    public void setLector(Lector lector){
        this.lector = lector;
    }
    public Lector getLector(){
        return this.lector;
    }

    public String toString(){
        return "Name of lecture is " + this.name + ", and it's lector is " + this.lector;
    }
}
