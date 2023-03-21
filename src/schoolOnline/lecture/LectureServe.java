package schoolOnline.lecture;

public class LectureServe {
    public static Lecture lectureCreate(){
        return new Lecture();
    }
    public static Lecture lectureCreate(int courseId){
        return new Lecture(courseId);
    }
}
