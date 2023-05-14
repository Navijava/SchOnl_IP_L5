package schoolOnline.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Log {
    Log(){}
    public Log(String className, int level){
        this.name = className;
        this.level = level;
        this.data = LocalDateTime.now();
    }
    String name;
    int level;
    String message;
    private LocalDateTime data;
    public String dateToWrite(){
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:SSS");
        return dtf.format(ldt);
    }
    private void data(){
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:SSS");
        // this.data = dtf.format(ldt);
    }
    String stacktrace;

}
