package schoolOnline;

import schoolOnline.courses.Course;
import schoolOnline.courses.CourseServe;
import schoolOnline.lecture.Lecture;
import schoolOnline.lecture.LectureServe;

public class Test {
    public static void main(String [] arg){

        Course course1 = CourseServe.courseCreate();

        Lecture lecture1 = LectureServe.lectureCreate(course1.getId());
        Lecture lecture2 = LectureServe.lectureCreate(course1.getId());
        Lecture lecture3 = LectureServe.lectureCreate(course1.getId());
        Lecture lecture4 = LectureServe.lectureCreate(course1.getId());
        Lecture lecture5 = LectureServe.lectureCreate(course1.getId());
        Lecture lecture6 = LectureServe.lectureCreate(course1.getId());

        System.out.println("Course id of lecture " + lecture6.getId() + " is - " + lecture6.courseId +
                ", and number of all lectures is - " + Lecture.lectureCount + ".");

    }
}
