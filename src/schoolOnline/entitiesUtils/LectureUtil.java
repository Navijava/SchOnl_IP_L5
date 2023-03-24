package schoolOnline.entitiesUtils;

import java.util.Scanner;

import schoolOnline.entities.Course;
import schoolOnline.entities.Lecture;

public class LectureUtil {

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
