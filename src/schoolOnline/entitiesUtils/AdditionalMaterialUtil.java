package schoolOnline.entitiesUtils;

import schoolOnline.entities.AdditionalMaterial;
import schoolOnline.repositories.AdditionalMaterialRepository;

public class AdditionalMaterialUtil {
    public static void generate(int lectureId){
        AdditionalMaterialRepository.add(new AdditionalMaterial(lectureId));
    }
}
