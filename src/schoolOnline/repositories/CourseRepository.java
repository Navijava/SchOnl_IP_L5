package schoolOnline.repositories;

import schoolOnline.entities.Course;
import schoolOnline.entities.Lecture;

public class CourseRepository  {
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

    public Lecture getById(int id) {
        for(int i = 0; i < courseRepository.length; i++){
            if (courseRepository[i].getLectureRepository().getById(id) != null) {
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
            if (courseRepository[i].getLectureRepository().deleteById(id)){
                return true;
            }
//            for(int j = 0; j < courseRepository[i].getLectureRepository().getAll().length; j++){
//                if(courseRepository[i].getLectureRepository().getAll()[j] != null && courseRepository[i].getLectureRepository().getAll()[j].getId() == id){
//                    courseRepository[i].getLectureRepository().
//                            setLectureAddedCount(
//                                    courseRepository[i].getLectureRepository().getLectureAddedCount() - 1);
//                    courseRepository[i].getLectureRepository().getAll()[j] = null;
//                    return true;
//                }
//            }
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
}
