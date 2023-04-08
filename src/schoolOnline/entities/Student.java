package schoolOnline.entities;

public class Student extends Person{
    private static int studentCount;
    public Student(){
        studentCount++;
    }
    public static int getStudentCount(){
        return studentCount;
    }
}
