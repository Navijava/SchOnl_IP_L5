package schoolOnline;

import schoolOnline.entities.Lector;
import schoolOnline.entities.Role;
import schoolOnline.entitiesUtils.Service;
import schoolOnline.repositories.LectorRepository;

import java.util.Arrays;

public class Main {
    public static void main(String [] arg){

        Service.iteratorFun();

        // Service.findInfo();

        //Service.createValidPersons();

        // Service.lectureWithHomework();

        // Service.types();

        // Service.createValidPersons();

        /* Service.createPersons();

        Service.findInfo();

        new Lector(Role.LECTOR, 1, 1);
        new Lector(Role.LECTOR, 5, 1);
        new Lector(Role.LECTOR, 2, 2);
        System.out.println(LectorRepository.allLectors());*/

        // System.out.println(Arrays.toString(LectorRepository.lectorRepository));

    }
}
