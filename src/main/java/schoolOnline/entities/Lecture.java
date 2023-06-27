package schoolOnline.entities;

import schoolOnline.entitiesUtils.AdditionalMaterialUtil;
import schoolOnline.entitiesUtils.HomeworkUtil;
import schoolOnline.entitiesUtils.LogService;
import schoolOnline.entitiesUtils.LogUtil;
import schoolOnline.repositories.AdditionalMaterialRepository;
import schoolOnline.repositories.HomeworkRepository;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class Lecture implements Serializable {
    public Lecture(){
        this.id = ++lectureCount;
        date();
    }
    public Lecture(int courseId, int lecture_id, int lector_id, String date){
        ++lectureCount;
        this.courseId = courseId;
        this.id = lecture_id;
        this.lectorId = lector_id;
        this.lector = new Lector(Role.LECTOR, courseId, id);
        homeworkArr = new Homework[16];
        AdditionalMaterialUtil.generate(this.id);
        HomeworkUtil.generate(this.id);
        this.homeworkRepository = new HomeworkRepository();
        this.additionalMaterialRepository = new AdditionalMaterialRepository();
        date();
        this.lectureDate = date;
        this.creationDate = LogUtil.create("Lecture", Level.INFO, "lecture created", null);
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
        date();
        this.creationDate = LogUtil.create("Lecture", Level.INFO, "lecture created", null);
    }
    public Lecture(int courseId, String courseName){
        this.courseId = courseId;
        this.courseName = courseName;
        this.id = ++lectureCount;
        this.lector = new Lector(Role.LECTOR, courseId, id);
        homeworkArr = new Homework[16];
        AdditionalMaterialUtil.generate(this.id);
        HomeworkUtil.generate(this.id);
        this.homeworkRepository = new HomeworkRepository();
        this.additionalMaterialRepository = new AdditionalMaterialRepository();
        this.loggerRead =  LogService.readLogs("src/schoolOnline/logLevel.data");

        date();
        this.creationDate = LogUtil.create("Lecture",
                Level.INFO, "lecture created", null);
                //Level.valueOf(loggerRead.get(1)), "lecture created", null);
    }
    private ArrayList<String> loggerRead;
    private Integer id;
    private String name;
    private String creationDate;
    private int lectorId;
    public int getLectorId(){
        return this.lectorId;
    }
    public String getCreationDate(){
        return this.creationDate;
    }
    private String lectureDate;
    private LocalDate sortBy;
    public void setSortBy(LocalDate sortBy){
        this.sortBy = sortBy;
    }
    public LocalDate getSortBy(){
        return this.sortBy;
    }
    public String getLectureDate(){
        return this.lectureDate;
    }
    private void date(){
        LocalDateTime ldt = LocalDateTime.now();
        this.sortBy = LocalDate.now();
        /*
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:SSS");
        this.creationDate = dtf.format(ldt);
        */
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, EEEE HH:mm:ss", new Locale("en", "En"));
        this.lectureDate = dtf.format(ldt);
    }
    private Homework [] homeworkArr;
    private static int lectureCount;
    private String description;
    private int courseId;
    private int personId;
    private String courseName;
    public String getCourseName(){
        return this.courseName;
    }
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
        LogUtil.create("Lecture", Level.DEBUG, "get homework", null);
        return this.homeworkRepository;
    }
    private AdditionalMaterialRepository additionalMaterialRepository;
    public AdditionalMaterialRepository getAdditionalMaterialRepository(){
        LogUtil.create("Lecture", Level.DEBUG, "get additional material", null);
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
        return "Lecture's id is " + this.id + ", course id is " + this.courseId
                + ((courseName == null) ? "" : ", course name is " + this.courseName)
                + ", date of lecture creation is " + sortBy + ".";
//        return "Name of lecture is " + this.name + ", and it's lector is "
//                + this.lector;
    }
}
