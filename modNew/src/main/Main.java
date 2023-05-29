package main;

import human.Person;
import human.Personality;
import human.Student;
import service.Service;

import java.util.ServiceLoader;

public class Main {
    static String x = "________________________________________________";
    public static void main(String [] arg){

        System.out.println(x);

        Service.simulator();

        System.out.println(x);

        Personality pers1 = new Person();
        Personality pers2 = new Student();
        pers1.introduce();
        pers2.introduce();

        System.out.println(x);

        ServiceLoader<Personality> service = ServiceLoader.load(Personality.class);
        Personality serv = service.iterator().next();
        serv.introduce();

        Iterable<Personality> service1 = ServiceLoader.load(Personality.class);
        Personality serv1 = service1.iterator().next();
        serv1.introduce();

        ServiceLoader.load(Personality.class).iterator().next().introduce();

        System.out.println(x);

    }
}
