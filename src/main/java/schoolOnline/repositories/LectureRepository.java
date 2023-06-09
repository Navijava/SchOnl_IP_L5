package schoolOnline.repositories;

import schoolOnline.entities.Lecture;

import java.io.Serializable;
import java.util.ArrayList;

public class LectureRepository implements LectureRepositoryMeth, Iterable, Serializable {
    protected int lectureAddedCount = 0;
    private ArrayList<Lecture> lectureRepository;
    public LectureRepository(){
        this.lectureRepository = new ArrayList<>();
    }
    public LectureRepository(int capacity){
        this.lectureRepository = new ArrayList(capacity);
    }
    public int getLectureAddedCount(){
        return lectureAddedCount;
    }
    public void setLectureAddedCount(int lectureAddedCount){
        this.lectureAddedCount = lectureAddedCount;
    }

    public void add(Lecture lecture){
        lectureAddedCount++;
        lectureRepository.add(lecture);
    }

    public ArrayList<Lecture> getAll(){
        return lectureRepository;
    }
    public Lecture getById(int id){
        for(int i = 0; i < lectureRepository.size(); i++) {
            if(lectureRepository.get(i).getId() == id){
                return lectureRepository.get(i);
            }
        }
        return null;
    }
    public boolean deleteById(int id){
            for(int i = 0; i < lectureRepository.size(); i++) {
                if(lectureRepository.get(i).getId() == id){
                    lectureRepository.remove(lectureRepository.get(i));
                    lectureAddedCount--;
                    return true;
                }
            }
            return false;
    }
    public void showAllId(){
        String result = "\n";
        for (int i = 0; i < lectureRepository.size(); i++){
            if(lectureRepository.get(i) != null) {
                result = result + "lecture's id - " + + lectureRepository.get(i).getId()
                        + ", lecture's name - \"" + lectureRepository.get(i).getLectureName()
                        + "\", and lector's name " + lectureRepository.get(i).getLector().getName()
                        + " " + lectureRepository.get(i).getLector().getLastname() + "\n";
            }
        }
        if (result.equals("")) {
            System.out.println("There is no any lectures yet.");
            return;
        }
        System.out.println("Id and name of course lectures: " + result.substring(0, result.length() - 1) + ".");
        //System.out.println((result.length() > 2) ? result.substring(0, result.length() - 2) + "." : result);
    }

    public Lecture findAll(int id){
        SimpleIterator sitr = this.iterator();
        Lecture tempLecture;
        while(sitr.hasNext()){
            tempLecture = sitr.next();
            if(tempLecture.getId() == id){
                System.out.print("Lecture is found. ");
                return tempLecture;
            }
        }
        System.out.print("There is no lecture with such id. Result is ");
        return null;
    }

    public String toString(){
        String result = "";
        for(int i = 0; i < lectureRepository.size(); i++){
            if(lectureRepository.get(i) != null) {
                result = result + lectureRepository.get(i) + ", ";
            }
        }
        return result.substring(0, result.length() - 2);
        // return Arrays.toString(lectureRepository);
    }

    @Override
    public SimpleIterator iterator() {
        return new SimpleIterator(this);
    }
}
