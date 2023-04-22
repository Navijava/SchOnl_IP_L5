package schoolOnline.entities;

import java.util.Random;

public class Homework{
    public Homework(){
        this.id = ++homeworkCount;
    }
    public Homework(int lectureId){
        this.id = ++homeworkCount;
        this.lectureId = lectureId;
        this.task = Task.getByInt(new Random().nextInt(1, 6));
    }
    static int homeworkCount;
    private Integer id;
    private int lectureId;
    private Task task;
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
    public void setTask(Task task){
        this.task = task;
    }
    public Task getTask(){
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
        return "\nHomework id is " + this.id
                + " lecture id is " + this.lectureId
                + ", task is: " + this.task + ".";
    }
}
