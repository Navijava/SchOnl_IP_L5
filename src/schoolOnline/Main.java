package schoolOnline;

import schoolOnline.entities.Lector;
import schoolOnline.entities.Role;
import schoolOnline.entitiesUtils.Service;
import schoolOnline.entitiesUtils.Temp;
import schoolOnline.entitiesUtils.Temp1;
import schoolOnline.repositories.LectorRepository;
import schoolOnline.repositories.HomeworkRepository;
import schoolOnline.repositories.AdditionalMaterialRepository;

import java.util.Arrays;

public class Main {
    public static void main(String [] arg){

        Service.lesson32();

        //Service.lesson31();

        //Temp1.temp1();

        // Service.logAtLast();

        // Service.streamsPart1();

        // Service.getAdditionalMaterial();

        // Service.getByDate();

        // Service.dates();

        // Service.serializeEverything();

        // Service.threads();

        // Service.findInfo();

        // Service.sortEverything();

        // Service.iteratorFun();

        // Service.createValidPersons();

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
