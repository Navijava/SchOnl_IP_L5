package schoolOnline.repositories;

import schoolOnline.entities.Lecture;

public class LectureRepository extends CommonRepository{
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
