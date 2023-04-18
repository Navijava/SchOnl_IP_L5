package schoolOnline.repositories;

import schoolOnline.entities.Lecture;

import java.util.Iterator;

public class SimpleIterator implements Iterator {

    private Lecture[] lecturesArray;
    private int position;
    public SimpleIterator(LectureRepository lectureRepository) {
        this.lecturesArray = lectureRepository.getAll();
    }
    @Override
    public boolean hasNext() {
        if(position < lecturesArray.length && lecturesArray[position] != null){
            return true;
        }

        if(position < lecturesArray.length && lecturesArray[position] == null){
            position++;
            return hasNext();
        }
        /*
        // Without recursion:
        while(position < lecturesArray.length && lecturesArray[position] == null){
            position++;
            if(position < lecturesArray.length && lecturesArray[position] != null){
                return true;
            }
        }
        */

        return false;
    }

    @Override
    public Lecture next() {
        //Object lectureObject = arr[position];
        //position++;
        return lecturesArray[position++];
    }
    public void remove(){
        lecturesArray[position - 1] = null;
    }
}
