package schoolOnline.entitiesUtils;

import java.util.Scanner;

public class CommonUtil {

    public static void findInfo() {
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
    }

}