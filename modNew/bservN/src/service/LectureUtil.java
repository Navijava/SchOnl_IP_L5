package service;

import entities.Lecture;
import repositories.LectureRepository;

public class LectureUtil {
    public static void find(){

    }
    public static void addLecture(Lecture lecture, LectureRepository lectureRepository){
        lectureRepository.getLectureList().add(lecture);

    }
    public static void showAll(){

    }
}
