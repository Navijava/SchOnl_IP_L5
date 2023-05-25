package repositories;

import entities.Lecture;

import java.util.ArrayList;

public class LectureRepository {
    private static ArrayList<Lecture> lectureList = new ArrayList<>();
    public ArrayList<Lecture> getLectureList(){
        return this.lectureList;
    }
}
