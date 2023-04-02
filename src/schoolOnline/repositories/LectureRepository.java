package schoolOnline.repositories;

import schoolOnline.entities.Lecture;

import java.util.Arrays;

public class LectureRepository {
    public LectureRepository(){
        this.lectureRepository = new Lecture[16];
    }
    public LectureRepository(int capacity){
        this.lectureRepository = new Lecture[capacity];
    }
    private Lecture[] lectureRepository;
    private int lectureAddedCount = 0;
    public Lecture [] getLectureRepository(){
        return lectureRepository;
    }
    public int getLectureAddedCount(){
        return lectureAddedCount;
    }
    public void addLecture(Lecture lecture){
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
    public void showAllId(){
        String result = "";
        for (int i = 0; i < lectureRepository.length; i++){
            if(lectureRepository[i] != null) {
                result = result + "lecture's id - " + + lectureRepository[i].getId() + ", and name - " + lectureRepository[i].getName() + "\n";
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
