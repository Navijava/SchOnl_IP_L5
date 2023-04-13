package schoolOnline.entitiesUtils;

import schoolOnline.entities.Lecture;
import schoolOnline.entities.Person;
import schoolOnline.entities.Role;
import schoolOnline.repositories.CourseRepository;
import schoolOnline.repositories.LectorRepository;

import java.util.Scanner;

public class Service {

    public static void validation(Person person){
        if(nameCheck(person.getFirstname())){
            System.out.println("Firstname is correct.");
        } else {
            System.out.println("Incorrect Firstname.");
            return;
        }
        if(nameCheck(person.getLastname())){
            System.out.println("Lastname is correct.");
        }else {
            System.out.println("Incorrect lastname.");
            return;
        }
        if(phoneCheck(person.getPhone())){
            System.out.println("Phone has correct form.");
        }else {
            System.out.println("Incorrect phone.");
            return;
        }
        if(emailCheck(person.getEmail())){
            System.out.println("Email has correct form.");
        }else {
            System.out.println("Incorrect email.");
            return;
        }

    }
    public static boolean phoneCheck(String check){
        check = check.replaceAll("-","");
        if(check.length() < 10) {
            return false;
        }
        String base = "";
        for(int i = 48; i < 58; i ++){
            base = base + (char) i;
        }
        char [] chArr = check.toCharArray();
        for(int i = 0; i < chArr.length; i++){
            if(!(base.contains("" + chArr[i]))){
                return false;
            }
        }
        return true;
    }
    public static boolean emailCheck(String check){
        if(check.contains("@") && check.contains(".")){
            return true;
        }
        return false;
    }
    public static boolean nameCheck(String check){
        String base = "";
        char [] chArr = check.toCharArray();
        for(int i = 65; i < 91; i++){
            base = base + (char) i + (char) (i + 32);
        }
        for(int i = 0; i < chArr.length; i++){
            if(!(base.contains(chArr[i] + ""))){
                return false;
            }
        }
        return true;
    }

    public static void createValidPersons(){

        String firstname = "Victoria";
        String lastname = "Chub";
        String phone = "050-123-45-67";
        String email = "wow@wow.ua";

        for(int i = 0; i < 5; i++){
            Person prsn = new Person(Role.STUDENT, 2);
            prsn.setFirstname("Victoria");
            prsn.setLastname("Chub");
            prsn.setPhone("050-123-45-67");
            prsn.setEmail("wow@wow.ua");
            if(i == 1) {
                prsn.setFirstname("Victoria1");
            }
            if(i == 2) {
                prsn.setLastname("Chub1");
            }
            if(i == 3) {
                prsn.setPhone("050-123-45-6a");
            }
            if(i == 4) {
                prsn.setEmail("wowwow.ua");
            }
            validation(prsn);
            System.out.println();
        }
        /*
        Person person1 = new Person(Role.STUDENT, 2);
        person1.setFirstname("Victoria");
        person1.setLastname("Chub");
        person1.setPhone("050-123-45-67");
        person1.setEmail("wow@wow.ua");
        validation(person1);

        Person person2 = new Person(Role.STUDENT, 2);
        person2.setFirstname("Victoria1");
        person2.setLastname("Chub");
        person2.setPhone("050-123-45-67");
        person2.setEmail("wow@wow.ua");
        System.out.println();
        validation(person2);

        Person person3 = new Person(Role.STUDENT, 2);
        person3.setFirstname("Victoria");
        person3.setLastname("Chub1");
        person3.setPhone("050-123-45-67");
        person3.setEmail("wow@wow.ua");
        System.out.println();
        validation(person3);

        Person person4 = new Person(Role.STUDENT, 2);
        person4.setFirstname("Victoria");
        person4.setLastname("Chub");
        person4.setPhone("050-123-45-6a");
        person4.setEmail("wow@wow.ua");
        System.out.println();
        validation(person4);

        Person person5 = new Person(Role.STUDENT, 2);
        person5.setFirstname("Victoria");
        person5.setLastname("Chub");
        person5.setPhone("050-123-45-67");
        person5.setEmail("wowwow.ua");
        System.out.println();
        validation(person5);
         */
    }

    public static void createPersons(){

        Person person1 = new Person(Role.STUDENT, 2);
        Person person2 = new Person(Role.LECTOR, 1);
        Person person3 = new Person();
        System.out.println("\n" + person1 + "\n" + person2 + "\n" + person3 + "\n");

    }
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
//                    System.out.println("Enter id of the lector.");
//                    int chosenLectorId = scan1.nextInt();
//                    System.out.println("You choose lector with id " + chosenLectorId + ".");
                    System.out.println(LectorRepository.allLectors());
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