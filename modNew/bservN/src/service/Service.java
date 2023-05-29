package service;

import entities.Lecture;
//import human.Person;
import human.Person;
import human.Personality;
//import human.Student;
import human.Student;
import repositories.LectureRepository;


public class Service {
    private static String bound = "\n________________________________________________";
    public static void simulator(){
        LectureRepository lectureRepository = new LectureRepository();
        for(int i = 0; i < 11; i++) {
            LectureUtil.addLecture(new Lecture((i + 1), ("lecture_" + (i + 1))), lectureRepository);
        }
        int var1 = 0;
        do {
            var1 = consol.Console.askCustomer();
            switch(var1){
                case 1:
                    System.out.println("Now available several courses:\n1. Java.\n2. Python." +
                            "\n3. JavaScript." + bound);
                    break;
                case 2:
                    lectureRepository
                            .getLectureList()
                            .stream()
                            .forEach(System.out :: println);
                    System.out.println(bound);
                    break;
                case 3:
                    System.out.println("Our lectors:\n1. Yuriy.\n2. Denis.\n3. Anna." + bound);
                    break;
            }
        }while (var1 != 6);

        Person pers = new Person(28, "Ann");
        pers.introduce();
        Personality pers1 = new Person();
        pers1.introduce();
        Personality pers2 = new Student();
        pers2.introduce();

        Personality pers5 = new Personality() {
            @Override
            public void introduce() {
                System.out.println("Study hard to get a good result.");
            }
        };
        pers5.introduce();

        Personality pers3 = pers1 :: introduce;
        Personality pers4 = pers2 :: introduce;
        pers3.introduce();
        pers4.introduce();

        System.out.println("Have a nice day!");
    }
}
