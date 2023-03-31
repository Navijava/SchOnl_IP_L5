package schoolOnline.entitiesUtils;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import schoolOnline.entities.Course;
import schoolOnline.entities.Lecture;

public class LectureUtil {
    public static void lectureLimitedCreate(int lectureLimit){

        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Course [] courseArr = courseBaseCreate();
        int courseId;
        System.out.println("Possible to create " + lectureLimit + " lectures.");
        do{
            System.out.println("Choose course id where you wish to work. Possible id is between 1 and " +
                    courseArr.length + ".");
            courseId = scan1.nextInt();
            if(courseId < 1 || courseId > courseArr.length){
                System.out.println("Wrong choice!");
            }
        }while(courseId < 1 || courseId > courseArr.length);
        do {
            if (lectureLimit == Lecture.lectureCount) {
                System.out.println("Limit of " + lectureLimit + " lectures was reached, program " +
                        "finishes it work. Number of all lectures is - " + Lecture.lectureCount + ". List of created " +
                        "lectures: " + courseArr[courseId -1].lecture + ".");
                System.exit(0);
            }
            System.out.println("Press 'y' to create new lecture or 'n' to skip.");
            String create = scan2.nextLine();
            if(create.equals("y")) {
                System.out.println("Created new lecture, with course id " + courseId + ".");
                Lecture newLecture = new Lecture(courseId);
                System.out.println("Enter name of new lecture.");
                newLecture.setName(scan2.nextLine());
                courseArr[courseId - 1].lecture.add(newLecture);
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

    }
    static Course[] courseBaseCreate(){
        int rand = new Random().nextInt(5, 10);
        Course [] courseArr = new Course[rand];
        for(int i = 0; Course.courseCount < rand; i++){
            courseArr[i] = new Course();
            courseArr[i].lecture = new ArrayList<Lecture>();
        }
        return courseArr;
    }
    public static void lectureCreate(int quantity) {
        Course course1 = new Course();
        Lecture current = null;
        while(Lecture.lectureCount < quantity) {
            current = new Lecture(course1.getId());
        }
        System.out.println("Course id of lecture " + current.getId() + " is - " + current.courseId +
                ", and number of all lectures is - " + Lecture.lectureCount + ".\n");
    }


    public static void lectureCreate(){

        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        boolean answer = true;

        do {
            System.out.println("Press 'y' to create new lecture or 'n' to skip.");
            String create = scan2.nextLine();
            if(create.equals("y")) {
                System.out.println("Let's create new lecture, enter course id for new lecture.");
                Lecture newLecture = new Lecture(scan1.nextInt());
                System.out.println("Enter name of new lecture.");
                newLecture.setName(scan2.nextLine());
                System.out.println("Was created lecture named \"" + newLecture.getName() + "\", id of course of new lecture is - " + newLecture.courseId +
                        " and lectures id is - " + newLecture.getId() + ".");
            } else if(create.equals("n")){
                answer = false;
            } else {
                System.out.println("You've made incorrect choice. Number of all lectures is - " + Lecture.lectureCount);
                System.exit(0);
            }
        }
        while(answer);

        System.out.println("Number of all lectures is - " + Lecture.lectureCount);

    }

}
