package schoolOnline.entitiesUtils;

import schoolOnline.entities.Lecture;
import schoolOnline.repositories.CourseRepository;

import java.util.Scanner;

public class Service {

    public static void findInfo() {

        CourseRepository courseRepository = LectureUtil.lectureLimitedCreate_Lesson10r(8);
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        int answer = 0;
        while(true) {
            do {
                System.out.println("What information do you want to find: \n1. Course. \n2. Lecture. \n3. Lector. \n4. Student."
                        + "\n5. All information about course and available lectures. \n6. Find lecture by id. "
                        + "\n7. Remove lecture by id. \nEnter number and press \"Enter\"");
                answer = scan1.nextInt();
            } while (answer < 1 || answer > 7);
            switch (answer) {
                case 1:
                    for (int i = 0; i < courseRepository.courseRepository.length; i++) {
                        System.out.println("Number of lectures in course with id " + (i + 1) + " is " +
                                courseRepository.courseRepository[i].getLectureRepository().getLectureAddedCount() + ".");
                    }
                    System.out.println("Enter id of the course to see information about course (list of lectures id).");
                    int chosenCourseId = scan1.nextInt();
                    System.out.println("You choose course with id " + chosenCourseId + ". "
                            + courseRepository.courseRepository[chosenCourseId - 1]);
                    courseRepository.courseRepository[chosenCourseId - 1].getLectureRepository().showAllId();
                    break;

                case 2:

                    System.out.println("Information about all available lectures in all courses:");
                    for (int i = 0; i < courseRepository.courseRepository.length; i++) {
                        if (courseRepository.courseRepository[i].getLectureRepository().getAll().length != 0) {
                            System.out.println("Course id - " + (i + 1) + ", and its lectures:");
                            courseRepository.courseRepository[i].getLectureRepository().showAllId();
                        }
                    }
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

                case 5:
                    System.out.println("All information about course and available lectures:");
                    for (int i = 0; i < courseRepository.courseRepository.length; i++) {
                        System.out.println("Number of lectures in course with id " + (i + 1) + " is "
                                + courseRepository.courseRepository[i].getLectureRepository().getLectureAddedCount() + ".");
                    }
                    System.out.println("Information about all available lectures in all courses:");
                    for (int i = 0; i < courseRepository.courseRepository.length; i++) {
                        if (courseRepository.courseRepository[i].getLectureRepository().getAll().length != 0) {
                            System.out.println("Course id - " + (i + 1) + ", and its lectures:");
                            courseRepository.courseRepository[i].getLectureRepository().showAllId();
                        }
                    }
                    break;
                case 6:
                    System.out.println("Enter lecture id to find needed lecture.");
                    int wantedLectureId = scan1.nextInt();
                    if (courseRepository.getById(wantedLectureId) == null) {
                        System.out.println("There is no lecture with such ID");
                    } else {
                        System.out.println("Information about wanted lecture: \nLecture's course id is - "
                        + courseRepository.getById(wantedLectureId).getCourseId() + ",\n Lecture's name is - "
                                + courseRepository.getById(wantedLectureId).getName() + ".");
                    }
                    break;
                case 7:
                    System.out.println("Enter lecture id to remove this lecture.");
                    int deleteLectureId = scan1.nextInt();
                    if (courseRepository.deleteById(deleteLectureId) == true){
                        System.out.println("Lecture was successfully deleted.");
                    } else{
                        System.out.println("There is no lecture with such id.");
                    }
                    break;
                default:
                    System.out.println("No information.");
            }
            System.out.println("To stop enter \"n\", to continue enter whatever you want.");
            if (scan2.nextLine().equals("n")){
                break;
            }

        }
    }

}