package schoolOnline.entities;

public class Homework{
    public Homework(){}
    public Homework(int lectureId, String task){
        id = ++homeworkCount;
        this.lectureId = lectureId;
        this.task = task;
    }
    static int homeworkCount;
    private Integer id;
    private int lectureId;
    private String task;
    private String name;
    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setLectureId(int lectureId){
        this.lectureId = lectureId;
    }
    public int getLectureId(){
        return this.lectureId;
    }
    public void setTask(String task){
        this.task = task;
    }
    public String getTask(){
        return this.task;
    }
    private int date;
    public void setDate(int date){
        this.date = date;
    }
    public int getDate(){
        return date;
    }
    public String toString(){
        return "Lecture id of task is " + this.lectureId + ", task id " + this.id + ", task is: "
                + task + ".";
    }
}
