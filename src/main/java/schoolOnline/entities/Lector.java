package schoolOnline.entities;

import schoolOnline.repositories.LectorRepository;

import java.io.Serializable;
import java.util.Random;

public class Lector implements Comparable<Lector>, Serializable {
    LectorRepository lr;
    private static int lectorCount;
    private int lectureId;
    public Lector(){
        lectorCount++;
    }
//    public Lector(String name){
//        lectorCount++;
//        this.name = name;
//    }
    public Lector(String lastname){
        lectorCount++;
        this.lastname = lastname;
    }
    public Lector(Role role, int courseId, int lectureId){
        this.role = role;
        this.courseId = courseId;
        lectorCount++;
        Random rndChoosingName = new Random();
        rndChoosingName.nextInt();
        setName((TempNames.getTempName(new Random().nextInt(1, 5))).name());
        this.lectureId = lectureId;
        LectorRepository.addLector(this);
    }
    public Lector(Role role, int courseId, int lectorId, String name, String lastname){
        lectorCount++;
        this.role = role;
        this.courseId = courseId;
        this.lectorId = lectorId;
        this.name = name;
        this.lastname = lastname;
        LectorRepository.addLector(this);
    }

    public int getLectureId(){return lectureId;}
    public static int getLectorCount(){
        return lectorCount;
    }

    private String firstname;
    private String lastname;
    private String phone;
    private String email;

    private Role role;
    private int courseId;

    private Integer lectorId;
    public int getLectorId(){
        return this.lectorId;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    public String getFirstname(){
        return this.firstname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    public String getLastname(){
        return this.lastname;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return this.phone;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }

    private String name;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    private int age;
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }

    public void setRole(Role role){
        this.role = role;
    }
    public Role getRole(){
        return this.role;
    }
    public void setCourseId(int courseId){
        this.courseId = courseId;
    }
    public int getCourseId(){
        return this.courseId;
    }
    public String toString(){
        /*return (role == Role.STUDENT) ? "Student is studying at course with id " + this.courseId + ".":
                (role == Role.LECTOR) ? "Lector is teaching at course with id " + this.courseId + ".":
                        "Peron is unknown at course with id " + this.courseId + ".";*/
        return "Lector full name is: " + name + " " + lastname;
    }

    /*public String toString(){
        return this.getName();
    }*/

    public int compareTo(Lector lector){
        return this.lastname.compareTo(lector.lastname);
    }

}
