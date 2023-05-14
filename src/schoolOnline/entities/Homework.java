package schoolOnline.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class Homework implements Serializable {
    public Homework(){
        this.id = ++homeworkCount;
        deadLine();
    }
    public Homework(int lectureId){
        this.id = ++homeworkCount;
        this.lectureId = lectureId;
        this.task = Task.getByInt(new Random().nextInt(1, 6));
        deadLine();
    }
    static int homeworkCount;
    private Integer id;
    private int lectureId;
    private Task task;
    private String name;
    private String deadLine;
    private void deadLine(){
        LocalDate ld = LocalDate.now();
        ld =ld.plusDays(1);
        LocalDateTime ldt = ld.atTime(12, 00);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, HH:mm", new Locale("en", "EN"));
        this.deadLine = dtf.format(ldt);
    }
    public String getDeadLine(){
        return this.deadLine;
    }
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
