package schoolOnline.entitiesUtils;

import java.util.Random;
import java.util.Scanner;

import schoolOnline.entities.Course;
import schoolOnline.entities.Lecture;
import schoolOnline.repositories.CourseRepository;
import schoolOnline.repositories.LectureRepository;

public class LectureUtil {
    public static CourseRepository lectureLimitedCreate_Lesson10r(int lectureLimit){
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        CourseRepository courseRepository = courseBaseCreate_Lesson10r();
        int courseId;
        System.out.println("Random course and it's three lectures auto creation...");
        courseId = new Random().nextInt(0, courseRepository.courseRepository.length) + 1;
        System.out.println("Was created course with id " + courseId + "." + " Check random course id -- "
                + courseRepository.courseRepository[courseId - 1].getId() + ", is ok.");
        for (int i = 0; i < 3; i++) {
            Lecture newLecture = new Lecture(courseId);
            newLecture.setName("AutoLecture" + (i + 1));
            courseRepository.courseRepository[courseId - 1].lectureRepository.addLecture(newLecture);
        }
        System.out.println("Possible to create " + (lectureLimit - Lecture.lectureCount) + " lectures.");
        do{
           System.out.println("Choose course id where you wish to work. Possible id is between 1 and " +
                  courseRepository.courseRepository.length + ".");
           courseId = scan1.nextInt();
               if(courseId < 1 || courseId > courseRepository.courseRepository.length){
               System.out.println("Wrong choice!");
               }
        } while(courseId < 1 || courseId > courseRepository.courseRepository.length);
        do {
            System.out.println("Possible to create " + (lectureLimit - Lecture.lectureCount) + " lectures.");
            if (lectureLimit == Lecture.lectureCount) {
                System.out.println("Limit of " + lectureLimit + " lectures was reached, program "
                        + "finishes it work. Number of all lectures is - " + Lecture.lectureCount + ". List of created "
                        + "lectures: " + courseRepository.courseRepository[courseId - 1].lectureRepository + ".");
                System.exit(0);
            }
            System.out.println("Press 'y' to create new lecture or 'n' to skip.");
            String create = scan2.nextLine();
            if(create.equals("y")) {
                System.out.println("Created new lecture, with course id " + courseId + ".");
                Lecture newLecture = new Lecture(courseId);
                System.out.println("Enter name of new lecture.");
                newLecture.setName(scan2.nextLine());
                courseRepository.courseRepository[courseId - 1].lectureRepository.addLecture(newLecture);
                System.out.println("Was created lecture named \"" + newLecture.getName() + "\", id " +
                        "of course for created lecture is - " + newLecture.courseId + " and lectures id is - "
                        + newLecture.getId() + ".");
            } else if(create.equals("n")){
                break;
            } else {
                System.out.println("You've made incorrect choice. Number of all lectures is - " +
                        Lecture.lectureCount);
                System.exit(0);
            }
        }
        while(true);
        System.out.println("Number of all lectures is - " + Lecture.lectureCount);
        return courseRepository;
    }
    static CourseRepository courseBaseCreate_Lesson10r(){
        int rand = new Random().nextInt(5, 10);
        Course courseTemp;
        CourseRepository courseRepository = new CourseRepository(rand);
        for(int i = 0; Course.courseCount < rand; i++){
            courseTemp = new Course();
            courseTemp.lectureRepository = new LectureRepository(0);
            courseRepository.addCourse(courseTemp);
        }
        return courseRepository;
    }
}
