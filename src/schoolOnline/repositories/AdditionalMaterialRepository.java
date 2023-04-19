package schoolOnline.repositories;

import schoolOnline.entities.AdditionalMaterial;

import java.util.ArrayList;

public class AdditionalMaterialRepository {
    private static ArrayList<AdditionalMaterial> additionalMaterialRepository = new ArrayList();
    public static void setAdditionalMaterialRepository(ArrayList<AdditionalMaterial> additionalMaterialRepository){
        additionalMaterialRepository = additionalMaterialRepository;
    }
    public static ArrayList<AdditionalMaterial> getAdditionalMaterialRepository(){
        return additionalMaterialRepository;
    }

    public static boolean add(AdditionalMaterial additionalMaterial){
        if (additionalMaterial == null) {
            return false;
        }
        additionalMaterialRepository.add(additionalMaterial);
        return true;
    }
    public static AdditionalMaterial getById(Integer id){
        for(AdditionalMaterial addMat : additionalMaterialRepository){
            if(addMat.getId() == id) return addMat;
        }
        System.out.println("Additional material wasn't found. Result for your request is ");
        return null;
    }

}
