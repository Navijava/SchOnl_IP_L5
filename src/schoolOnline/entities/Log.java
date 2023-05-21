package schoolOnline.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    Log(){}
    public Log(String className, Level level, String message, String stacktrace){
        this.name = className;
        this.level = level;
        this.data = LocalDateTime.now();
        this.message = message;
        this.stacktrace = ((stacktrace == null) ? " is absent.\n" : (stacktrace + ".\n"));
    }
    public Log(String className, int level){
        this.name = className;
        this.levelOld = level;
        this.data = LocalDateTime.now();
    }

    private String name;
    public String getName(){
        return this.name;
    }
    int levelOld;
    private Level level;
    public Level getLevel(){
        return this.level;
    }
    private String message;
    public String getMessage(){
        return this.message;
    }
    private LocalDateTime data;
    public LocalDateTime getDate(){
        return this.data;
    }

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
    private String stacktrace;
    public String getStacktrace(){
        return this.stacktrace;
    }
    public String toString(){
        return "\rDate - " + this.data + "\nlevel - " + this.level + "\nclass - "
                + this.name + "\nmessage - " + this.message
                + "\nstacktrace - " + this.stacktrace + "\n";
    }

}
