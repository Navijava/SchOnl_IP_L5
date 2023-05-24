package schoolOnline.entitiesUtils;

import schoolOnline.entities.Level;
import schoolOnline.entities.Log;

import java.util.ArrayList;

public class LogUtil {
    private static ArrayList<Log> logArr = new ArrayList<>();
    public static ArrayList<Log> getLogs(){
        return logArr;
    }
    public static String create(String className, int level){
        Log log = new Log(className, level);
        logArr.add(log);
        String dateToWrite = log.dateToWrite();
        LogService.logWriteDate(dateToWrite);
        return dateToWrite;
    }
    public static String create(String className, Level level, String message, String stacktrace){
        Log log = new Log(className, level, message, stacktrace);
        logArr.add(log);
        String dateToWrite = log.dateToWrite();
        String dataToWrite = "Date - " + dateToWrite + "\nlevel - " + level + "\nclass - "
                + className + "\nmessage - " + message
                + "\nstacktrace - " + ((stacktrace == null) ? " is absent.\n" : (stacktrace + ".\n"));
        LogService.logWriteDate(dataToWrite);
        return dateToWrite;
    }
    public static void create(String className, String levels, String message, String stacktrace){
        Log log = new Log(className, levels, message, stacktrace);
        logArr.add(log);
        String dateToWrite = log.dateToWrite();
        String dataToWrite = "Date - " + dateToWrite + "\nlevel - " + levels + "\nclass - "
                + className + "\nmessage - " + message
                + "\nstacktrace - " + ((stacktrace == null) ? " is absent.\n" : (stacktrace + ".\n"));
        LogService.logWriteDataNio(dataToWrite);
    }
    public static void read(){}
}
