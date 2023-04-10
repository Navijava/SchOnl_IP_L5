package schoolOnline.entities;

public class Person {
    public Person(){}
    public Person(Role role, int courseId){
        this.role = role;
        this.courseId = courseId;
    }
    private Role role;
    private int courseId;

    private int id;

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
        return (role == Role.STUDENT) ? "Student is studying at course with id " + this.courseId + ".":
                (role == Role.LECTOR) ? "Lector is teaching at course with id " + this.courseId + ".":
                        "Peron is unknown at course with id " + this.courseId + ".";
    }

}
