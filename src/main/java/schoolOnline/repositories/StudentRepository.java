package schoolOnline.repositories;

import schoolOnline.entities.Student;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentRepository implements Serializable {
    private int studentCount = 0;
    private ArrayList<Student> studentRepository;
    public ArrayList<Student> getStudentRepository(){
        return this.studentRepository;
    }
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
        if(studentRepository == null
                || (id - 1) > studentRepository.size()
                || id < 0){
            return studentRepository.get(id);
        }
        return null;
    }
    public Student getByLastname(String lastname) throws Exception{
        for(int i = 0; i < studentRepository.size(); i++){
            if(studentRepository.get(i).getLastname().equals(lastname)){
                return studentRepository.get(i);
            }
        }
        return null;
    }

}
