package schoolOnline.repositories;

import schoolOnline.entities.Student;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentRepository implements Serializable {
    private int studentCount = 0;
    private ArrayList<Student> studentRepository;
    public StudentRepository(){
        this.studentRepository = new ArrayList<>();
    }
    public int getStudentCount(){
        return this.studentCount;
    }
    public void add(Student student){
        studentRepository.add(student);
        studentCount++;
    }
    public Student getById(int id){
        return studentRepository.get(id);
    }

}
