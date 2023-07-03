package schoolOnline.entities;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Comparable<Student>, Serializable {
    private static int studentCount;
    public Student(){
        studentCount++;
    }
    public Student(String lastname){
        this.lastname = lastname;
        studentCount++;
    }
    public Student(int courseId){
        this.courseId = courseId;
        studentCount++;
    }
    public static int getStudentCount(){
        return studentCount;
    }
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private Role role;
    private int courseId;
    private int studentId;
    private int courseQuantity;
    public void setCourseQuantity(int courseQuantity){
        this.courseQuantity = courseQuantity;
    }
    public int getCourseQuantity(){
        return this.courseQuantity;
    }
    public void setStudentId(int studentId){
        this.studentId = studentId;
    }
    public int getStudentId(){
        return this.studentId;
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
   /*     return (role == Role.STUDENT) ? "Student is studying at course with id " + this.courseId + ".":
                (role == Role.LECTOR) ? "Lector is teaching at course with id " + this.courseId + ".":
                        "Peron is unknown at course with id " + this.courseId + ".";*/
        //return "\nStudent's name is " + name + ".";
        //return "\nStudent's lastname is " + lastname + ".";
        return lastname + " " + firstname;
    }
    public int compareTo(Student student){
        return this.lastname.compareTo(student.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastname);
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(lastname, student.lastname);
    }
}
