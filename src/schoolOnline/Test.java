package schoolOnline;

import schoolOnline.lecture.Lecture;
import schoolOnline.lecture.LectureServe;

public class Test {
    public static void main(String [] arg){
        Lecture lecture1 = LectureServe.lectureCreate();
        Lecture lecture2 = LectureServe.lectureCreate();
        Lecture lecture3 = LectureServe.lectureCreate();
        Lecture lecture4 = LectureServe.lectureCreate();
        Lecture lecture5 = LectureServe.lectureCreate();
        System.out.println("Lecture number is " + Lecture.lectureCount + ".");
    }
}
