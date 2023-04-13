package schoolOnline.entities;

public class Person {
    public Person(){}
    public Person(Role role, int courseId){
        this.role = role;
        this.courseId = courseId;
    }

    private String firstname;
    private String lastname;
    private String phone;
    private String email;

    private Role role;
    private int courseId;

    private int id;

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
        return (role == Role.STUDENT) ? "Student is studying at course with id " + this.courseId + ".":
                (role == Role.LECTOR) ? "Lector is teaching at course with id " + this.courseId + ".":
                        "Peron is unknown at course with id " + this.courseId + ".";
    }

}
