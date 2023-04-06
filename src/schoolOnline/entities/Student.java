package schoolOnline.entities;

public class Student extends Academy{
    private static int studentCount;
    private int age;
    public Student(){
        studentCount++;
    }
    public static int getStudentCount(){
        return studentCount;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
}
