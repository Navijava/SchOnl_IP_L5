package schoolOnline.entities;

import schoolOnline.entitiesUtils.AdditionalMaterialUtil;
import schoolOnline.entitiesUtils.HomeworkUtil;
import schoolOnline.repositories.AdditionalMaterialRepository;
import schoolOnline.repositories.HomeworkRepository;

import java.io.Serializable;

public class Lecture implements Serializable {
    public Lecture(){
        this.id = ++lectureCount;
    }
    public Lecture(int courseId){
        this.courseId = courseId;
        this.id = ++lectureCount;
        this.lector = new Lector(Role.LECTOR, courseId, id);
        homeworkArr = new Homework[16];
        AdditionalMaterialUtil.generate(this.id);
        HomeworkUtil.generate(this.id);
        this.homeworkRepository = new HomeworkRepository();
        this.additionalMaterialRepository = new AdditionalMaterialRepository();
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
    /*public void addHomework(Homework homework){
        HomeworkUtil.add(homeworkArr, homework);
    }
    public Homework getHomeworkById(int homeworkId){
        return HomeworkUtil.getById(this.homeworkArr, homeworkId);
    }*/
    public void setHomeworkArr(Homework[] homeworkArr){
        this.homeworkArr = homeworkArr;
    }
    public Homework[] getHomeworkArr(){
        return this.homeworkArr;
    }
    private HomeworkRepository homeworkRepository;
    public HomeworkRepository getHomeworkRepository(){
        return this.homeworkRepository;
    }
    private AdditionalMaterialRepository additionalMaterialRepository;
    public AdditionalMaterialRepository getAdditionalMaterialRepository(){
        return this.additionalMaterialRepository;
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
