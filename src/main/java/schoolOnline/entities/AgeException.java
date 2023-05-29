package schoolOnline.entities;

public class AgeException  extends Exception{
    public String getMessage(){
        return "too young";
    }
    public String toString(){
        return "you must be at least 18 yo...";
    }
}