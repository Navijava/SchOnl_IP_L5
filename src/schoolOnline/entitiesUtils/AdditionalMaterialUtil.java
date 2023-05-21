package schoolOnline.entitiesUtils;

import schoolOnline.entities.AdditionalMaterial;
import schoolOnline.repositories.AdditionalMaterialRepository;

import java.util.Random;

public class AdditionalMaterialUtil {
    public static void generate(int lectureId){
        for(int i = 0; i < new Random().nextInt(1, 6); i++) {
            AdditionalMaterialRepository.add(new AdditionalMaterial(lectureId));
        }
    }
}
