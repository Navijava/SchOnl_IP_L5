package schoolOnline.repositories;

import schoolOnline.entities.Lector;
import schoolOnline.entities.Lecture;

import java.util.Arrays;

public class LectorRepository {
/*    LectorRepository(Lector [] lectorArray){
        this.lectorRepository = lectorArray;
    }*/
    public static Lector[] lectorRepository = new Lector[16];
    public static void addLector(Lector lector){
        if(!checkSpace()){
            lectorRepository = increaseSpace();
        }
        for(int i = 0; i < lectorRepository.length; i++){
            if(lectorRepository[i] == null) {
                lectorRepository[i] = lector;
                return;
            }
        }
    }

    static boolean checkSpace(){
        for (int i = 0; i < lectorRepository.length; i++){
            if(lectorRepository[i] == null) {
                return true;
            }
        }
        return false;
    }

    static Lector[] increaseSpace(){
        Lector [] lectorRepositoryRes = new Lector[(lectorRepository.length * 3) / 2 + 1];
        for(int i = 0; i < lectorRepository.length; i++){
            lectorRepositoryRes[i] = lectorRepository[i];
        }
        return lectorRepositoryRes;
    }

    public static boolean deleteById(int lectureId){
        for (int i = 0; i < lectorRepository.length; i++){
            if(lectorRepository[i] != null && lectorRepository[i].getLectureId() == lectureId){
                lectorRepository[i] = null;
                return true;
            }
        }
        return false;
    }

    public static String allLectors(){
        String result = "All lectors are:\n";
        for(int i = 0; i < lectorRepository.length; i++){
            if (lectorRepository[i] != null){
                result = result +  "At course with id " + lectorRepository[i].getCourseId() +
                        ", and lecture id " + lectorRepository[i].getLectureId() +
                        " lector is " + lectorRepository[i].getName() + ".\n";
            }
        }
        return result;
    }
    public static String allLectors2(){
        String result = "All lectors are:\n";
        for(int i = 0; i < lectorRepository.length; i++){
            if (lectorRepository[i] != null){
                result = result +  "At course with id " + lectorRepository[i].getCourseId() +
                        " lector is " + lectorRepository[i].getName() +
                        " "+ lectorRepository[i].getLastname() + ".\n";
            }
        }
        return result;
    }

}
