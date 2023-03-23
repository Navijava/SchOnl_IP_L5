package schoolOnline;

import schoolOnline.courses.Course;
import schoolOnline.courses.CourseServe;
import schoolOnline.lecture.Lecture;
import schoolOnline.lecture.LectureServe;

import java.util.Scanner;

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

        System.out.println("What information do you want to find: \n1. Course. \n2. Lecture. \n3. Lector. \n4. Student." +
                "\nEnter number and press \"Enter\"");
        Scanner scan1 = new Scanner(System.in);
        switch(scan1.nextInt()) {
            case 1:
                System.out.println("Enter id of the course.");
                int chosenCourseId = scan1.nextInt();
                System.out.println("You choose course with id " + chosenCourseId + ".");
                break;

            case 2:
                System.out.println("Enter id of the lecture.");
                int chosenLectureId = scan1.nextInt();
                System.out.println("You choose lecture with id " + chosenLectureId + ".");
                break;

            case 3:
                System.out.println("Enter id of the lector.");
                int chosenLectorId = scan1.nextInt();
                System.out.println("You choose lector with id " + chosenLectorId + ".");
                break;

            case 4:
                System.out.println("Enter id of the student.");
                int chosenStudentId = scan1.nextInt();
                System.out.println("You choose student with id " + chosenStudentId + ".");
                break;

            default:
                System.out.println("No information.");
        }

        boolean answer = true;
        Scanner scan2 = new Scanner(System.in);

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
        }while(answer);

        System.out.println("Number of all lectures is - " + Lecture.lectureCount);

    }
}
