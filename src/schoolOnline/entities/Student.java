package schoolOnline.entities;

public class Student {
    private static int studentCount;
    private int id;
    private String name;
    private int age;
    public Student(){
        studentCount++;
    }
    public static int getStudentCount(){
        return studentCount;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
}
