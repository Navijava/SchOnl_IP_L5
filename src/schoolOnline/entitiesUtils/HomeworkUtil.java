package schoolOnline.entitiesUtils;

import schoolOnline.entities.Homework;

public class HomeworkUtil {
    public static Homework[] add(Homework [] homeworkArr, Homework homework){
        if(!checkSpace(homeworkArr)){
            increaseSpace(homeworkArr);
        }
        for(int i = 0; i < homeworkArr.length; i++){
            if(homeworkArr[i] == null){
                homeworkArr[i] = homework;
            }
        }
        return homeworkArr;
    }

    public static Homework getById(Homework [] homeworkArr, int homeworkId){
        for(int i = 0; i < homeworkArr.length; i++){
            if(homeworkArr[i].getId() == homeworkId) {
                return homeworkArr[i];
            }
        }
        System.out.println("No homework with id " + homeworkId + ".");
        return null;
    }

    private static boolean checkSpace(Homework[] homeworkArr){
        for(int i = 0; i < homeworkArr.length; i++){
            if(homeworkArr[i] == null) return true;
        }
        return false;
    }

    private static Homework[] increaseSpace(Homework[] homeworkArr){
        Homework[] tempHomeworkArr = new Homework[homeworkArr.length * 3 / 2 + 1];
        for(int i = 0; i < homeworkArr.length; i++){
            tempHomeworkArr[i] = homeworkArr[i];
        }
        homeworkArr = tempHomeworkArr;
        return homeworkArr;
    }


}
