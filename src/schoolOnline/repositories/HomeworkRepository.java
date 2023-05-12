package schoolOnline.repositories;

import schoolOnline.entities.AdditionalMaterial;
import schoolOnline.entities.Homework;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
public class HomeworkRepository implements Serializable {
    private static HashMap<Integer, ArrayList<Homework>> homeworkRepository = new HashMap<>();
    //private static HashMap<Integer, ArrayList<AdditionalMaterial>> additionalMaterialMap = new HashMap<>();
    public static void setAdditionalMaterialRepository(ArrayList<Homework> homeworkRepository){
        homeworkRepository = homeworkRepository;
    }
    public static HashMap<Integer, ArrayList<Homework>> getHomeworkRepository(){
        return homeworkRepository;
    }

    public static boolean add(Homework homework){
        if (homework == null) {
            return false;
        }
        if(homeworkRepository.get(homework.getLectureId()) == null){
            homeworkRepository.put(homework.getLectureId(), new ArrayList<Homework>());
        }
        homeworkRepository.get(homework.getLectureId()).add(homework);
        return true;
    }
    public static Homework getById(Integer id){
        for(Integer key : homeworkRepository.keySet()){
            for (int i = 0; i < homeworkRepository.get(key).size(); i++){
                if(homeworkRepository.get(key).get(i) != null
                        && homeworkRepository.get(key).get(i).getId() == id) {
                    return homeworkRepository.get(key).get(i);
                }
            }
        }
        return null;
    }

    public static boolean removeById(Integer id){
        for(Integer key : homeworkRepository.keySet()){
            for (int i = 0; i < homeworkRepository.get(key).size(); i++){
                if(homeworkRepository.get(key).get(i) != null
                        && homeworkRepository.get(key).get(i).getId() == id) {
                    homeworkRepository.get(key).remove(i);

                    return true;
                }
            }
        }
        return false;
    }

    public static String print(){
        String result = "";
        for(int key : homeworkRepository.keySet()){
            result = result + "\nFor lecture id " + key + " homework is:";
            for(int i = 0; i < homeworkRepository.get(key).size(); i++){
                result = result + homeworkRepository.get(key).get(i);
            }
        }
        return result;
    }

}
