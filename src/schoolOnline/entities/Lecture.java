package schoolOnline.entities;

import schoolOnline.entitiesUtils.HomeworkUtil;

public class Lecture{
    public Lecture(){
        this.id = ++lectureCount;
    }
    public Lecture(int courseId){
        this.courseId = courseId;
        this.id = ++lectureCount;
        this.lector = new Lector(Role.LECTOR, courseId, id);
        homeworkArr = new Homework[16];
    }
    private Integer id;
    private String name;
    public String commonName;
    private Homework [] homeworkArr;
    private static int lectureCount;
    private String description;
    private int courseId;
    private int personId;
    private Lector lector;
    public void addHomework(Homework homework){
        HomeworkUtil.add(homeworkArr, homework);
    }
    public Homework getHomeworkById(int homeworkId){
        return HomeworkUtil.getById(this.homeworkArr, homeworkId);
    }
    public void setHomeworkArr(Homework[] homeworkArr){
        this.homeworkArr = homeworkArr;
    }
    public Homework[] getHomeworkArr(){
        return this.homeworkArr;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return id;
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
        return "Lecture's id is " + this.id + ", and course id is " + this.courseId;
//        return "Name of lecture is " + this.name + ", and it's lector is "
//                + this.lector;
    }
}
