package schoolOnline.entities;

public class Student {
    public static int studentCount;
    private int id;
    String name;
    int age;
    public Student(){
        studentCount++;
    }
}
