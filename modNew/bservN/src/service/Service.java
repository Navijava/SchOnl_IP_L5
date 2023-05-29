package service;

import entities.Lecture;
import repositories.LectureRepository;

public class Service {
    private static String bound = "\n________________________________________________";
    public static void simulator(){
        LectureRepository lectureRepository = new LectureRepository();
        System.out.println(bound);
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

        System.out.println("Have a nice day!");
    }
}
