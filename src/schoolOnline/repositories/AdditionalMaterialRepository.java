package schoolOnline.repositories;

import schoolOnline.entities.AdditionalMaterial;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class AdditionalMaterialRepository implements Serializable {
    private static HashMap<Integer, ArrayList<AdditionalMaterial>> additionalMaterialMap = new HashMap<>();
    //private static HashMap<Integer, ArrayList<AdditionalMaterial>> additionalMaterialMap = new HashMap<>();
    public static void setAdditionalMaterialMap(ArrayList<AdditionalMaterial> additionalMaterialMap){
        additionalMaterialMap = additionalMaterialMap;
    }
    public static HashMap<Integer, ArrayList<AdditionalMaterial>> getAdditionalMaterialMap(){
        return additionalMaterialMap;
    }

    public static boolean add(AdditionalMaterial additionalMaterial){
        if (additionalMaterial == null) {
            return false;
        }
        if(additionalMaterialMap.get(additionalMaterial.getLectureId()) == null){
            additionalMaterialMap.put(additionalMaterial.getLectureId(), new ArrayList<AdditionalMaterial>());
        }
        additionalMaterialMap.get(additionalMaterial.getLectureId()).add(additionalMaterial);
        return true;
    }
    public static AdditionalMaterial getById(Integer id){
        for(Integer key : additionalMaterialMap.keySet()){
            for (int i = 0; i < additionalMaterialMap.get(key).size(); i++){
                if(additionalMaterialMap.get(key).get(i) != null
                        && additionalMaterialMap.get(key).get(i).getId() == id) {
                    return additionalMaterialMap.get(key).get(i);
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
        for(Integer key : additionalMaterialMap.keySet()){
            for (int i = 0; i < additionalMaterialMap.get(key).size(); i++){
                if(additionalMaterialMap.get(key).get(i) != null
                        && additionalMaterialMap.get(key).get(i).getId() == id) {
                    additionalMaterialMap.get(key).remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public static String print(){
        String result = "";
        for(int key : additionalMaterialMap.keySet()){
            result = result + "\n\nFor lecture with id " + key + " additional material is:";
            for(int i = 0; i < additionalMaterialMap.get(key).size(); i++){
                result = result + additionalMaterialMap.get(key).get(i);
            }
        }
        return result;
    }

}
