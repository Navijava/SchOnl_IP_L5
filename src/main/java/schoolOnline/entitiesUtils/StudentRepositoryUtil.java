package schoolOnline.entitiesUtils;

import schoolOnline.entities.Student;
import schoolOnline.repositories.StudentRepository;

public class StudentRepositoryUtil {
    StudentRepository studentRepository;
    public StudentRepositoryUtil(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public boolean isAvailable(Student student) throws Exception{
        return studentRepository.getByLastname(student.getLastname()) != null;
    }
}
