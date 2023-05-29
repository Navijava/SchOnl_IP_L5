package schoolOnline.repositories;

import schoolOnline.entities.Course;
import schoolOnline.entities.Lecture;

public interface CourseRepositoryMeth {
    public void addCourse(Course course);
    public Lecture getById(int id);
    public boolean deleteById(int id);
}
