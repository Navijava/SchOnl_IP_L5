package schoolOnline.repositories;

import schoolOnline.entities.AdditionalMaterial;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class AdditionalMaterialRepository implements Serializable {
    private static HashMap<Integer, ArrayList<AdditionalMaterial>> additionalMaterialRepository = new HashMap<>();
    //private static HashMap<Integer, ArrayList<AdditionalMaterial>> additionalMaterialMap = new HashMap<>();
    public static void setAdditionalMaterialRepository(ArrayList<AdditionalMaterial> additionalMaterialRepository){
        additionalMaterialRepository = additionalMaterialRepository;
    }
    public static HashMap<Integer, ArrayList<AdditionalMaterial>> getAdditionalMaterialRepository(){
        return additionalMaterialRepository;
    }

    public static boolean add(AdditionalMaterial additionalMaterial){
        if (additionalMaterial == null) {
            return false;
        }
        if(additionalMaterialRepository.get(additionalMaterial.getLectureId()) == null){
            additionalMaterialRepository.put(additionalMaterial.getLectureId(), new ArrayList<AdditionalMaterial>());
        }
        additionalMaterialRepository.get(additionalMaterial.getLectureId()).add(additionalMaterial);
        return true;
    }
    public static AdditionalMaterial getById(Integer id){
        for(Integer key : additionalMaterialRepository.keySet()){
            for (int i = 0; i < additionalMaterialRepository.get(key).size(); i++){
                if(additionalMaterialRepository.get(key).get(i) != null
                        && additionalMaterialRepository.get(key).get(i).getId() == id) {
                    return additionalMaterialRepository.get(key).get(i);
                }
            }
        }
//        for(AdditionalMaterial addMat : additionalMaterialRepository){
//            if(addMat.getId() == id) return addMat;
//        }
//        System.out.println("Additional material wasn't found. Result for your request is ");
        return null;
    }

    public static boolean removeById(Integer id){
        for(Integer key : additionalMaterialRepository.keySet()){
            for (int i = 0; i < additionalMaterialRepository.get(key).size(); i++){
                if(additionalMaterialRepository.get(key).get(i) != null
                        && additionalMaterialRepository.get(key).get(i).getId() == id) {
                    additionalMaterialRepository.get(key).remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public static String print(){
        String result = "";
        for(int key : additionalMaterialRepository.keySet()){
            result = result + "\n\nFor lecture with id " + key + " additional material is:";
            for(int i = 0; i < additionalMaterialRepository.get(key).size(); i++){
                result = result + additionalMaterialRepository.get(key).get(i);
            }
        }
        return result;
    }

}
