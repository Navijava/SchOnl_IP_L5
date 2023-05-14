package schoolOnline.entitiesUtils;

import schoolOnline.entities.Log;

import java.util.ArrayList;

public class LogUtil {
    static ArrayList<Log> logArr = new ArrayList<>();
    public static String create(String className, int level){
        Log log = new Log(className, level);
        logArr.add(log);
        String dateToWrite = log.dateToWrite();
        LogService.logWriteDate(dateToWrite);
        return dateToWrite;

    }
    public static void read(){}
}
