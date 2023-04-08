package schoolOnline.entities;

import schoolOnline.repositories.LectorRepository;

import java.util.Random;

public class Lector extends Person{
    LectorRepository lr;
    private static int lectorCount;
    private int lectureId;
    public Lector(){
        lectorCount++;
    }
    public Lector(Role role, int courseId, int lectureId){
        super(role, courseId);
        lectorCount++;
        Random rndChoosingName = new Random();
        rndChoosingName.nextInt();
        super.setName((TempNames.getTempName(new Random().nextInt(1, 5))).name());
        this.lectureId = lectureId;
        LectorRepository.addLector(this);
    }

    public int getLectureId(){return lectureId;}
    public static int getLectorCount(){
        return lectorCount;
    }

    public String toString(){
        return this.getName();
    }

}
