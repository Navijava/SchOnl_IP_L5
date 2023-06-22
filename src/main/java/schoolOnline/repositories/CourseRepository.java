package schoolOnline.repositories;

import schoolOnline.entities.Course;
import schoolOnline.entities.Lecture;

public class CourseRepository implements CourseRepositoryMeth {
    public CourseRepository(){
        this.courseRepository = new Course[16];
    }
    public CourseRepository(int capacity){
        this.courseRepository = new Course[capacity];
    }
    public CourseRepository(Course[] courseRepository){
        this.courseRepository = courseRepository;
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
            if(courseRepository[i] == null) {
                return true;
            }
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

    public Lecture getById(int id) {
        for(int i = 0; i < courseRepository.length; i++){
            if (courseRepository[i] != null && courseRepository[i].getLectureRepository().getById(id) != null) {
                return courseRepository[i].getLectureRepository().getById(id);
            }
//            for(int j = 0; j < courseRepository[i].getLectureRepository().getAll().length; j++){
//                if(courseRepository[i].getLectureRepository().getAll()[j] != null && courseRepository[i].getLectureRepository().getAll()[j].getId() == id){
//                    return courseRepository[i].getLectureRepository().getAll()[j];
//                }
//            }
        }
        return null;
    }
    public boolean deleteById(int id) {
        for(int i = 0; i < courseRepository.length; i++){
            if (courseRepository[i] != null && courseRepository[i].getLectureRepository().deleteById(id)){
                return true;
            }
        }
        return false;
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

    public void print(){
        String result = "";
        for (int i = 0; i < courseRepository.length; i++) {
            if (courseRepository[i].getLectureRepository().getAll().size() != 0) {
                System.out.println("Course id - " + (i + 1) + ", and its lectures:");
                courseRepository[i].getLectureRepository().showAllId();
            }
        }
    }

}
