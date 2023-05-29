package schoolOnline.repositories;

import schoolOnline.entities.Lecture;

public class CommonRepository {
    protected int lectureAddedCount = 0;
    protected Lecture[] lectureRepository;

    public void add(Lecture lecture){
        lectureAddedCount++;
        if(!checkSpace()){
            lectureRepository = increaseSpace();
        }
        for(int i = 0; i < lectureRepository.length; i++){
            if(lectureRepository[i] == null) {
                lectureRepository[i] = lecture;
                return;
            }
        }
    }
    boolean checkSpace(){
        for (int i = 0; i < lectureRepository.length; i++){
            if(lectureRepository[i] == null) return true;
        }
        return false;
    }
    Lecture[] increaseSpace(){
        Lecture [] lectureRepositoryRes = new Lecture[(lectureRepository.length * 3) / 2 + 1];
        for(int i = 0; i < lectureRepository.length; i++){
            lectureRepositoryRes[i] = lectureRepository[i];
        }
        return lectureRepositoryRes;
    }

    public Lecture[] getAll(){
        return lectureRepository;
    }
    public Lecture getById(int id){
        for(int i = 0; i < lectureRepository.length; i++){
            if(lectureRepository[i] != null && lectureRepository[i].getId() == id){
                return lectureRepository[i];
            }
        }
        return null;
    }
    public boolean deleteById(int id){
        for(int i = 0; i < lectureRepository.length; i++){
            if(lectureRepository[i] != null && lectureRepository[i].getId() == id){
                lectureAddedCount = lectureAddedCount - 1;
                LectorRepository.deleteById(lectureRepository[i].getId());
                lectureRepository[i] = null;
                return true;
            }
        }
        return false;
    }

}
