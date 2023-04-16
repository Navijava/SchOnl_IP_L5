package schoolOnline.repositories;

import schoolOnline.entities.Lecture;

public class LectureRepository implements LectureRepositoryMeth {
    protected int lectureAddedCount = 0;
    protected Lecture[] lectureRepository;
    public LectureRepository(){
        this.lectureRepository = new Lecture[16];
    }
    public LectureRepository(int capacity){
        this.lectureRepository = new Lecture[capacity];
    }
    public int getLectureAddedCount(){
        return lectureAddedCount;
    }
    public void setLectureAddedCount(int lectureAddedCount){

        this.lectureAddedCount = lectureAddedCount;
    }

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
    public boolean checkSpace(){
        for (int i = 0; i < lectureRepository.length; i++){
            if(lectureRepository[i] == null) return true;
        }
        return false;
    }
    public Lecture[] increaseSpace(){
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
    public void showAllId(){
        String result = "\n";
        for (int i = 0; i < lectureRepository.length; i++){
            if(lectureRepository[i] != null) {
                result = result + "lecture's id - " + + lectureRepository[i].getId()
                        + ", and name - " + lectureRepository[i].getName()
                        + ", and lector's name " + lectureRepository[i].getLector().getName() + "\n";
            }
        }
        if (result.equals("")) {
            System.out.println("There is no any lectures yet.");
            return;
        }
        System.out.println("Id and name of course lectures: " + result.substring(0, result.length() - 1) + ".");
        //System.out.println((result.length() > 2) ? result.substring(0, result.length() - 2) + "." : result);
    }
    public String toString(){
        String result = "";
        for(int i = 0; i < lectureRepository.length; i++){
            if(lectureRepository[i] != null) {
                result = result + lectureRepository[i] + ", ";
            }
        }
        return result.substring(0, result.length() - 2);
        // return Arrays.toString(lectureRepository);
    }
}
