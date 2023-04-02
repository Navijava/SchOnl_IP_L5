package schoolOnline.repositories;

import schoolOnline.entities.Course;
import schoolOnline.entities.Lecture;

public class CourseRepository {
    public CourseRepository(){
        this.courseRepository = new Course[16];
    }
    public CourseRepository(int capacity){
        this.courseRepository = new Course[capacity];
    }
    public Course[] courseRepository;
    public void addCourse(Course course){
        if(!checkSpace()){
            courseRepository = increaseSpace();
        }
        for(int i = 0; i < courseRepository.length; i++){
            if(courseRepository[i] == null) {
                courseRepository[i] = course;
                return;
            }
        }
    }
    boolean checkSpace(){
        for (int i = 0; i < courseRepository.length; i++){
            if(courseRepository[i] == null) return true;
        }
        return false;
    }
    Course [] increaseSpace(){
        Course [] courseRepositoryRes = new Course[(courseRepository.length * 3) / 2 + 1];
        for(int i = 0; i < courseRepository.length; i++){
            courseRepositoryRes[i] = courseRepository[i];
        }
        return courseRepositoryRes;
    }
    public String toString(){
        String result = "";
        for(int i = 0; i < courseRepository.length; i++){
            if(courseRepository[i] != null) {
                result = result + courseRepository[i] + ", ";
            }
        }
        return (result.length() > 2) ? result.substring(0, result.length() - 2) : "No information.";
        // return Arrays.toString(lectureRepository);
    }
}
