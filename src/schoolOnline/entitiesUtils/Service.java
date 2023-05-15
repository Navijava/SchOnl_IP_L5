package schoolOnline.entitiesUtils;

import schoolOnline.entities.*;
import schoolOnline.repositories.*;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Service {

    static String bound = "\n__________________________________________________________________\n";
    public static void logAtLast(){
        Scanner scan1 = new Scanner(System.in);
        Course course1 = new Course("Java");
        // To fill in log file with new logs:
        Lecture lecture1 = new Lecture(course1.getId());
        lecture1.getAdditionalMaterialRepository();
        lecture1.getHomeworkRepository();
        int age = 0;
        do{
            System.out.println("Enter your age:");
            try {
                age = scan1.nextInt();
                if(age < 18) {
                    throw new AgeException();
                }
            }catch(InputMismatchException e){
                LogUtil.create("Main", Level.ERROR, "wrong data", "" + e.getStackTrace());
                System.err.println("wrong data");
                scan1 = new Scanner(System.in);
            }catch(AgeException e){
                LogUtil.create("Main", Level.WARNING, e.getMessage(), "" + e.getStackTrace());
                System.out.println("Call your mommy or daddy.");
            }
        }while(age < 18);
        System.out.println("Congratulations. See you later.");

        LogUtil.create("Main", Level.DEBUG, "program finishes its work", null);
        System.out.println("All actual logs:\n" + LogUtil.getLogs());

        Scanner scan2 = new Scanner(System.in);
        String answer = "";
        do {
            System.out.println("\nWhat kind of log information you wish to see\n1. Log dates.\n2. Log levels." +
                    "\n3. Log names.\n4. Log messages.\n5. Log Stacktraces.\n6. Just finish." +
                    "\nInput number and press enter.");
            scan1 = new Scanner(System.in);
            int temp = -1;
            do {
                try {
                    temp = scan1.nextInt();
                } catch (Exception e) {
                    System.out.println("Wrong data, try again.");
                    scan1 = new Scanner(System.in);
                }
                if (temp < 1 || temp > 6) {
                    System.out.println("Make correct choice.");
                }
            } while (temp < 1 || temp > 6);
            switch (temp) {
                case 1:
                    LogUtil.getLogs().stream().forEach(log -> System.out.println(log.getDate()));
                    break;
                case 2:
                    LogUtil.getLogs().stream().forEach(log -> System.out.println(log.getLevel()));
                    break;
                case 3:
                    LogUtil.getLogs().stream().forEach(log -> System.out.println(log.getName()));
                    break;
                case 4:
                    LogUtil.getLogs().stream().forEach(log -> System.out.println(log.getMessage()));
                    break;
                case 5:
                    LogUtil.getLogs().stream().forEach(log -> System.out.println(log.getStacktrace()));
                    break;
                case 6:
                    System.out.println("Have a nice day.");
                    System.exit(10);
                default:
                    System.out.println("Something go wrong...");
            }
            System.out.println("To continue input \"y\" and press enter, to finish input whatever and " +
                    "press enter");
            answer = scan2.nextLine();
        }while(answer.equals("y"));

    }
    public static void streamsPart1(){
        Scanner scan1 = new Scanner(System.in);

        // Question 3:
        System.out.println("All messages from log file:");
        ArrayList<String> logList = LogService.readLogs();
        logList.stream()
                .filter(log -> log.contains("message"))
                .forEach(System.out :: println);
        System.out.println(bound);

        // Question 1:
        Course course1 = new Course("Java");
        Course course2 = new Course();
        System.out.println(course1.getName());
        System.out.println(Optional.ofNullable(course2.getName())
                .orElse("choose another course"));
        System.out.println(bound);

        // Question 2:
        List<String> lastNamesList = List.of("Ignatenko", "Nadichuk", "bbb", "Johnsoniuk", "Petrenko",
                "nnn", "Ninoska", "Annanko", "Bobriuk", "sss","Susanko", "Blajenko", "ccc", "Mictorchuk",
                "Purjeniuk", "Nanasko");
        course1.setLectors();
        ArrayList<String> lectorLastnames = new ArrayList<>();
        lastNamesList.stream()
                .filter(lastname -> lastname.length() > 3)
                .forEach(lastname -> {
                    course1.getLectors().add(new Lector(lastname));
                    lectorLastnames.add(lastname);
                });

        System.out.println("All lastnames:\n" + lectorLastnames +"\n\nLastnames before \"N\":");
        course1.getLectors().stream()
                .filter(lector -> lector.getLastname().substring(0, 1).compareTo("N") < 0)
                .forEach(lector -> System.out.println(lector.getLastname()));
        System.out.println(bound);

        // To fill in log file with new logs:
        Lecture lecture1 = new Lecture(course1.getId());
        lecture1.getAdditionalMaterialRepository();
        lecture1.getHomeworkRepository();
        int age = 0;
        do{
            System.out.println("Enter your age:");
            try {
                age = scan1.nextInt();
                if(age < 18) {
                    throw new AgeException();
                }
            }catch(InputMismatchException e){
                LogUtil.create("Main", Level.ERROR, "wrong data", "" + e.getStackTrace());
                throw e;
            }catch(AgeException e){
                LogUtil.create("Main", Level.WARNING, e.getMessage(), "" + e.getStackTrace());
                System.out.println("Call your mommy or daddy.");
            }
        }while(age < 18);
        System.out.println("Congratulations. See you later.");

        LogUtil.create("Main", Level.DEBUG, "program finishes its work", null);

    }
    public static void getByDate(){

        Course course = new Course("Java");
        ArrayList<Lecture> list = course.getLectureRepository().getAll();
        Lecture tempLecture;
        for(int i = 0; i < 10; i ++){
            tempLecture = new Lecture(course.getId());
            tempLecture.setSortBy(tempLecture.getSortBy().plusDays(i * 3));
            list.add(tempLecture);
        }
        String str = "" + LocalDate.now().plusDays(15);
        LocalDate ld1 = LocalDate.now().plusDays(6);
        LocalDate ld2 = LocalDate.now().plusDays(20);
        ShowInfo show = () -> {
            for(int i = 0; i < list.size(); i++){
                System.out.println(list.get(i).getSortBy());
            }
        };
        ShowByPeriod show1 = (String period) -> {
            switch(period){
                case "after":
                    for(int i = 0; i < list.size(); i++){
                        if(list.get(i).getSortBy().isAfter(LocalDate.parse(str))){
                            System.out.println(list.get(i).getSortBy());
                        }
                    }
                    break;
                case "before":
                    for(int i = 0; i < list.size(); i++){
                        if(list.get(i).getSortBy().isBefore(LocalDate.parse(str))){
                            System.out.println(list.get(i).getSortBy());
                        }
                    }
                    break;
                case "between":
                    for(int i = 0; i < list.size(); i++){
                        if(list.get(i).getSortBy().isAfter(ld1)
                                && list.get(i).getSortBy().isBefore(ld2)){
                            System.out.println(list.get(i).getSortBy());
                        }
                    }
                    break;
            }
        };

        System.out.println("dates of all lectures:\n");
        show.showEverything();

        System.out.println("\n\n1. after " + str + ":\n");
        show1.show("after");

        System.out.println("\n\n2. before " + str + ":\n");
        show1.show("before");

        System.out.println("\n\n3. between " + ld1 + " and "  +ld2 + ":\n");
        show1.show("between");
    }

    public static void getAdditionalMaterial(){
        Course course = new Course("Java");
        for(int i = 0; i < 5; i ++){
            course.getLectureRepository().add(new Lecture(course.getId()));
        }
        ShowInfo show = () -> {
            System.out.println(course.getLectureRepository().getById(1).getAdditionalMaterialRepository().print());
        };

        System.out.print(bound + "\nAll additional materials by lectures id:");
        show.showEverything();
        System.out.println(bound);
    }

    public static void dates(){
        Lecture lecture = new Lecture(10);
        System.out.println(bound);
        System.out.println("Log info for this lecture:\n" + lecture.getCreationDate());
        System.out.println("\nLecture date is:\n" + lecture.getLectureDate());
        System.out.println("\nDeadLine for homework is:\n" + lecture.getHomeworkRepository().getById(1).getDeadLine());

        System.out.println(bound + "Log info about all lectures:");
        LogService.printLogs();

    }

    public static void serializeEverything(){
        Course course = new Course("Java");
        Lecture tempLecture;
        Student tempStudent;
        for(int i = 0; i < 11; i++){
            tempLecture = new Lecture(course.getId());
            tempLecture.setName("lecture " + (i + 1));
            tempLecture.getHomeworkRepository().add(new Homework(tempLecture.getId()));
            tempLecture.getAdditionalMaterialRepository().add(new AdditionalMaterial(tempLecture.getId()));
            course.getLectureRepository().add(tempLecture);
        }
        for(int i = 0; i < 20; i++){
            tempStudent = new Student(course.getId());
            tempStudent.setName("Student" + (i + 1));
            course.getStudentRepository().add(tempStudent);
        }
        System.out.println(bound + "Information BEFORE serialization: \ncourse -- " + course.getName()
                + "\nlector -- " + course.getLector().getName()
                + "\nsome lecture -- " + course.getLectureRepository().getById(5).getName()
                + "\nsome homework -- "
                + course.getLectureRepository().getById(6).getHomeworkRepository().getById(6)
                + "\nsome additional material -- "
                + course.getLectureRepository().getById(7).getAdditionalMaterialRepository().getById(7)
                + "\nstudent -- " + course.getStudentRepository().getById(8));

        ser(course);

        Course savedCourse = deSer();

        System.out.println(bound + "Information AFTER serialization: \ncourse -- " + savedCourse.getName()
                + "\nlector -- " + savedCourse.getLector().getName()
                + "\nsome lecture -- " + savedCourse.getLectureRepository().getById(5).getName()
                + "\nsome homework -- "
                + savedCourse.getLectureRepository().getById(6).getHomeworkRepository().getById(6)
                + "\nsome additional material -- "
                + savedCourse.getLectureRepository().getById(7).getAdditionalMaterialRepository().getById(7)
                + "\nstudent -- " + course.getStudentRepository().getById(8));

    }

    static void ser(Course course){
        try(ObjectOutputStream objTo =
           new ObjectOutputStream(new FileOutputStream(new File ("src/schoolOnline/course.obj")))) {
            objTo.writeObject(course);
        } catch(Exception e) {}
    }

    static Course deSer() {
        try(ObjectInputStream objectFrom =
            new ObjectInputStream(new FileInputStream(new File ("src/schoolOnline/course.obj")))){
            return (Course) objectFrom.readObject();
        }catch(Exception e) {}
        return null;
    }

    public static void threads(){

        try{
            ArrayList<String> arrDone = new ArrayList<>();
            ArrayList<Integer> taskList = new ArrayList<>();
            TreeMap<String, Boolean> result = new TreeMap<>();

            for(int i = 0; i < 10; i++){
                taskList.add((i + 1));
            }

            Thread tmpThr = null;

            for(int i = 1; i < 11; i++){
                String student = "Student " + i;
                result.put(student, false);
                tmpThr = new Thread(()->{
                    try {
                        Thread.sleep(new Random().nextInt(8, 15) * 1000);
                        arrDone.add(Thread.currentThread().getName());
                        result.put(Thread.currentThread().getName(), true);
                    } catch (InterruptedException e) { }
                });
                tmpThr.setName(student);
                System.out.println(tmpThr.getName() + " get task "
                        + taskList.remove(new Random().nextInt(taskList.size())) + ".");
                tmpThr.setDaemon(true);
                tmpThr.start();
            }
            Thread.sleep(12000);
            for(String std : result.keySet()){
                if(result.get(std) && ! arrDone.contains(std)){
                    arrDone.add(std);
                }
            }
            System.out.println(bound);
            for(int i = 0; i < arrDone.size(); i++){
                System.out.println(arrDone.get(i) + " finished " + (i + 1) + ".");
            }
            for(String std : result.keySet()){
                if(! result.get(std)){
                    System.out.println(std + " failed.");
                }
            }

        }catch(InterruptedException e){}
    }

    public static void sortEverything(){

        ArrayList<Course> courseList = new ArrayList<>(List.of(
                new Course("Python"),
                new Course("Java"),
                new Course("Ruby"),
                new Course("Swift"),
                new Course("Kotlin")
        ));

        System.out.println(courseList  + "\n");
        courseList.sort(null);
        System.out.println("After sort:\n" + courseList + "\n" + bound);

        ArrayList<Lector> lectorList = new ArrayList<>(List.of(
                new Lector("Petrenko"),
                new Lector("Chub"),
                new Lector("Moroziuk"),
                new Lector("Zelenko"),
                new Lector("Viy")

        ));

        System.out.println(lectorList + "\n");
        lectorList.sort(null);
        System.out.println("After sort:\n" + lectorList + "\n" + bound);

        ArrayList<Student> studentList = new ArrayList<>(List.of(
                new Student("Mask"),
                new Student("Kook"),
                new Student("Vozniak"),
                new Student("Gates"),
                new Student("Jobs")

        ));

        System.out.println(studentList + "\n");
        studentList.sort(null);
        System.out.println("After sort:\n" + studentList + "\n" + bound);

        ArrayList<AdditionalMaterial> additionalMaterialList = new ArrayList<>(List.of(
                new AdditionalMaterial(new Random().nextInt(1, 11)),
                new AdditionalMaterial(new Random().nextInt(1, 11)),
                new AdditionalMaterial(new Random().nextInt(1, 11)),
                new AdditionalMaterial(new Random().nextInt(1, 11)),
                new AdditionalMaterial(new Random().nextInt(1, 11))

        ));
        System.out.println(additionalMaterialList + "\n");
        Scanner scan1 = new Scanner(System.in);
        int sortChoice;
        do {
            System.out.println("How would you like to sort additional materials:\n1. By id.\n2. By lecture id." +
                    "\n3. By resource type.\nInput number and press \"Enter\"");
            try {
                sortChoice = scan1.nextInt();
                switch(sortChoice){
                    case 1:
                        additionalMaterialList.sort(null);
                        System.out.println("After sort:\n" + additionalMaterialList + "\n" + bound);
                        break;

                    case 2:
                        Comparator<AdditionalMaterial> comparator1 = new Comparator<>(){
                            public int compare(AdditionalMaterial a, AdditionalMaterial b){
                                return a.getLectureId() - b.getLectureId();
                            }
                        };
                        additionalMaterialList.sort(comparator1);
                        System.out.println("After sort:\n" + additionalMaterialList + "\n" + bound);
                        break;

                    case 3:
                        Comparator<AdditionalMaterial> comparator2 = new Comparator<>(){
                            public int compare(AdditionalMaterial a, AdditionalMaterial b){
                                return b.getResourceType().compareTo(a.getResourceType());
                            }
                        };
                        additionalMaterialList.sort(comparator2);
                        System.out.println("After sort:\n" + additionalMaterialList + "\n" + bound);
                        break;

                    default:
                        throw new ValidationException();
                }
            } catch (Exception e) {
                System.out.println("Wrong choice, try again");
                sortChoice = 0;
                scan1 = new Scanner(System.in);
            }
        }//while(true);
        while(sortChoice < 1 || sortChoice > 3);
    }
    public static void iteratorFun(){

        LectureRepository lectureRepository = new LectureRepository();
        Lecture tempLecture;
        for(int i = 0; i < 10; i++){
            lectureRepository.add(new Lecture(11));
        }
        SimpleIterator sitr = lectureRepository.iterator();

        System.out.println("\nBefore removing lecture with id 6.\n");
        while(sitr.hasNext()){
            System.out.println(sitr.next());
        }
        sitr = lectureRepository.iterator();
        while (sitr.hasNext()) {
            tempLecture = sitr.next();
            if(tempLecture.getId() == 6){
                sitr.remove();
                //break;
            }
        }
        sitr = lectureRepository.iterator();

        System.out.println("\nAfter removing lecture with id 6.\n");
        while(sitr.hasNext()){
            System.out.println(sitr.next());
        }

        System.out.println("_______________________________________________________________________");
        System.out.println("Trying to find lecture with id 10, result:");
        System.out.println(lectureRepository.findAll(10));
        System.out.println("\nTrying to find lecture with id 12, result:");
        System.out.println(lectureRepository.findAll(12));

    }
/*    public static void lectureWithHomework(){

        final int courseId = 10;
        Lecture lecture = new Lecture(courseId);
        Homework homework1 = new Homework(lecture.getId(), "jump 10 times");
        lecture.addHomework(homework1);
        System.out.println(lecture.getHomeworkById(2) + "\n\n" + lecture.getHomeworkById(1));

    }*/

    public static void types(){
        LectureRepository lectureRepository = new LectureRepository(3);
        Lecture tempLecture;
        for(int i = 0; i < 2; i++){
            new Random().nextInt(1, 10);
            tempLecture = new Lecture(new Random().nextInt(1, 10));
            tempLecture.setName("lecture" + (i + 1));
            lectureRepository.add(tempLecture);

        }
        TypedRepository<Lecture> typedRepository =
                new TypedRepository<>(lectureRepository.getAll().toArray(new Lecture []{}));

        System.out.println("\n__________________________________________________________________________\n");
        System.out.println("Empty? - " + typedRepository.isEmpty() + "\nSize? - " + typedRepository.size());

        System.out.println("Trying to get by negative index - ");
        typedRepository.get(-1);
        System.out.println("Trying to get by too big index - ");
        typedRepository.get(100);
        System.out.println("Trying to get by null index - ");
        typedRepository.get(2);
        System.out.println("Trying to get by by correct index - " + typedRepository.get(1));
        System.out.println("\n__________________________________________________________________________\n");

        System.out.println("Before simple adding: \nSize - " + typedRepository.size() + "\nCapacity - " + typedRepository.capacity());
        tempLecture = new Lecture(new Random().nextInt(1, 10));
        tempLecture.setName("lectureAdded_1");
        typedRepository.add(tempLecture);
        tempLecture = new Lecture(new Random().nextInt(1, 10));
        tempLecture.setName("lectureAdded_2");
        typedRepository.add(tempLecture);
        tempLecture = new Lecture(new Random().nextInt(1, 10));
        tempLecture.setName("lectureAdded_3");
        typedRepository.add(tempLecture);
        System.out.println("After simple adding: \nSize - " + typedRepository.size() + "\nCapacity - " + typedRepository.capacity());
        System.out.println("\n__________________________________________________________________________\n");

        System.out.println("Before adding by index:\nSize - " + typedRepository.size()
                + "\nCapacity - " + typedRepository.capacity());

        tempLecture = new Lecture(new Random().nextInt(1, 10));
        tempLecture.setName("lectureAdded_4");
        typedRepository.add(2, tempLecture);

        System.out.println("After adding by index:\nSize - " + typedRepository.size()
                + "\nCapacity - " + typedRepository.capacity());
        System.out.println("\n__________________________________________________________________________\n");

        System.out.println("Remove by negative index , answer:");
        typedRepository.remove(-10);
        System.out.println("Remove by too big index, answer:");
        typedRepository.remove(100);
        System.out.println("Remove null object index, answer:");
        typedRepository.remove(7);
        System.out.println("Remove by correct index.");
        typedRepository.remove(5);
        //System.out.println("Negative index.");

/*        for(int i = 0; i < typedRepository.capacity(); i++){
            if(typedRepository.get(i) != null){
                System.out.println(typedRepository.get(i).getName());
            }
        }*/


    }

    public static void validation(Person person){
        try {
            if (nameCheck(person.getFirstname())) {
                System.out.println("Firstname is correct.");
            } else {
                System.out.println("Incorrect Firstname.");
                throw new ValidationException();
                //return;
            }
            if (nameCheck(person.getLastname())) {
                System.out.println("Lastname is correct.");
            } else {
                System.out.println("Incorrect lastname.");
                throw new ValidationException();
                //return;
            }
            if (phoneCheck(person.getPhone())) {
                System.out.println("Phone has correct form.");
            } else {
                System.out.println("Incorrect phone.");
                throw new ValidationException();
                //return;
            }
            if (emailCheck(person.getEmail())) {
                System.out.println("Email has correct form.");
            } else {
                System.out.println("Incorrect email.");
                throw new ValidationException();
                // return;
            }
        }catch(ValidationException e){
            System.out.println(e + "\n" + e.getMessage());
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
                System.out.println("What information do you want to find: \n1. Course. \n2. Lecture. \n3. Lector. "
                        + "\n4. Student. \n5. All information about course and available lectures. "
                        + "\n6. Find lecture by id. \n7. Remove lecture by id.\n8. Get additional material for lecture."
                        + "\n9. Get homework for lecture. \nEnter number and press \"Enter\"");
                try {
                    answer = scan1.nextInt();
                } catch(Exception e){
                    System.out.println("Wrong symbol. Try again.");
                    scan1 = new Scanner(System.in);
                }
            } while (answer < 1 || answer > 9);
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
//                    for (int i = 0; i < courseRepository.courseRepository.length; i++) {
//                        if (courseRepository.courseRepository[i].getLectureRepository().getAll().size() != 0) {
//                            System.out.println("Course id - " + (i + 1) + ", and its lectures:");
//                            courseRepository.courseRepository[i].getLectureRepository().showAllId();
//                        }
//                    }
                    courseRepository.print();
                    System.out.println("Choose next step:\n1. Get information about all homework by lecture id." +
                            "\n2. Get information about all additional task by lecture id." +
                            "\n3. Return to main menu");
                    int step = -1;
                    do {
                        try {
                            step = scan1.nextInt();
                        } catch (Exception e) {
                            System.out.println("Wrong symbol. Try again.");
                            scan1 = new Scanner(System.in);
                        }
                    }while(step < 1 || step > 3);
                    switch(step){
                        case 1:
                            System.out.println(HomeworkRepository.print());
                            System.out.println("Choose next step:\n1. Add new homework." +
                                    "\n2. Remove homework." +
                                    "\n3. Return to main menu");
                            int step1 = -1;
                            do {
                                try {
                                    step1 = scan1.nextInt();
                                } catch (Exception e) {
                                    System.out.println("Wrong symbol. Try again.");
                                    scan1 = new Scanner(System.in);
                                }
                            }while(step1 < 1 || step1 > 3);
                            courseRepository.print();
                            switch(step1){
                                case 1:
                                    System.out.println("Choose lecture id from available in the list to which you want "
                                            + "add homework.");
                                    int step2 = -1;
                                    do {
                                        try {
                                            step2 = scan1.nextInt();
                                            if(courseRepository.getById(step2) == null){
                                                throw new ValidationException();
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Wrong symbol. Try again.");
                                            scan1 = new Scanner(System.in);
                                        }
                                    }while(courseRepository.getById(step2) == null);
                                    HomeworkRepository.add(new Homework(step2));
                                    System.out.println("Homework was successfully added." + HomeworkRepository.print());
                                    break;
                                case 2:
                                    System.out.println(HomeworkRepository.print()
                                            + "\nChoose homework id from available in the list which you want remove.");
                                    int step3 = -1;
                                    try {
                                        step3 = scan1.nextInt();
                                    } catch (Exception e) {
                                        System.out.println("Wrong symbol. Try again.");
                                        scan1 = new Scanner(System.in);
                                    }
                                    if(HomeworkRepository.removeById(step3)){
                                        System.out.println("Homework was successfully removed." + HomeworkRepository.print());
                                    } else{
                                        System.out.println("There is no homework with id "  + step3 + ".\n"
                                                + HomeworkRepository.print());
                                    }
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println(AdditionalMaterialRepository.print());
                            System.out.println("Choose next step:\n1. Add new additional material." +
                                    "\n2. Remove additional material." +
                                    "\n3. Return to main menu");
                            int step4 = -1;
                            do {
                                try {
                                    step4 = scan1.nextInt();
                                } catch (Exception e) {
                                    System.out.println("Wrong symbol. Try again.");
                                    scan1 = new Scanner(System.in);
                                }
                            }while(step4 < 1 || step4 > 3);
                            courseRepository.print();
                            switch(step4){
                                case 1:
                                    System.out.println("Choose lecture id from available in the list to which you "
                                            + "want add additional material.");
                                    int step5 = -1;
                                    do {
                                        try {
                                            step5 = scan1.nextInt();
                                            if(courseRepository.getById(step5) == null){
                                                throw new ValidationException();
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Wrong symbol. Try again.");
                                            scan1 = new Scanner(System.in);
                                        }
                                    }while(courseRepository.getById(step5) == null);
                                    AdditionalMaterialRepository.add(new AdditionalMaterial(step5));
                                    System.out.println("Additional material was successfully added."
                                            + AdditionalMaterialRepository.print());
                                    break;
                                case 2:
                                    System.out.println(AdditionalMaterialRepository.print()
                                            + "\nChoose additional material id from available in the list which "
                                            + "you want remove.");
                                    int step6 = -1;
                                    try {
                                        step6 = scan1.nextInt();
                                    } catch (Exception e) {
                                        System.out.println("Wrong symbol. Try again.");
                                        scan1 = new Scanner(System.in);
                                    }
                                    if(AdditionalMaterialRepository.removeById(step6)){
                                        System.out.println("Additional material was successfully removed."
                                                + AdditionalMaterialRepository.print());
                                    } else{
                                        System.out.println("There is no additional material with id "  + step6 + ".\n"
                                                + AdditionalMaterialRepository.print());
                                    }
                                    break;
                            }


                            break;
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
                        if (courseRepository.courseRepository[i].getLectureRepository().getAll().size() != 0) {
                            System.out.println("Course id - " + (i + 1) + ", and its lectures:");
                            courseRepository.courseRepository[i].getLectureRepository().showAllId();
                        }
                    }
                    break;

                case 6:

                    System.out.println("Enter lecture id to find needed lecture.");
                    try {
                        int wantedLectureId = scan1.nextInt();
                        if (courseRepository.getById(wantedLectureId) == null) {
                            throw new EntityNotFoundException();
                        }
                        /*if (courseRepository.getById(wantedLectureId) == null) {
                            System.out.println("There is no lecture with such ID");
                        } else {*/
                        System.out.println("Information about wanted lecture: \nLecture's course id is - "
                                + courseRepository.getById(wantedLectureId).getCourseId() + ",\n Lecture's name is - "
                                + courseRepository.getById(wantedLectureId).getName() + ".");
                        //}
                    } catch (EntityNotFoundException e) {
                        System.out.println(e + "\n" + e.getMessage());
                    }
                    break;

                case 7:

                    System.out.println("Enter lecture id to remove this lecture.");
                    try {
                        int deleteLectureId = scan1.nextInt();
                        if (courseRepository.deleteById(deleteLectureId) == true) {
                            System.out.println("Lecture was successfully deleted.");
                        } else {
                            throw new EntityNotFoundException();
                            //System.out.println("There is no lecture with such id.");
                        }
                    }catch(EntityNotFoundException e){
                        System.out.println(e + "\n" + e.getMessage());
                    }
                    break;

                case 8:

                    System.out.println("Enter id of additional material which you want to find.");
                    try {
                        int addMatId = scan1.nextInt();
                        System.out.println(AdditionalMaterialRepository.getById(addMatId)
                                + "\nAll additional materials:\n" +
                                AdditionalMaterialRepository.getAdditionalMaterialRepository());

                    }catch(Exception e){
                        scan1 = new Scanner(System.in);
                        System.out.println("Incorrect symbol, try again.");
                    }
                    break;

                case 9:

                    System.out.println("Enter id of homework which you want to find.");
                    try {
                        int homewokrId = scan1.nextInt();
                        System.out.println(HomeworkRepository.getById(homewokrId)
                                + "\nAll additional materials:\n" +
                                HomeworkRepository.print());

                    }catch(Exception e){
                        scan1 = new Scanner(System.in);
                        System.out.println("Incorrect symbol, try again.");
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