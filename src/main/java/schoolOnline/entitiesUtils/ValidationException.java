package schoolOnline.entitiesUtils;

public class ValidationException extends Exception{
    public String getMessage(){
        return "Try again.";
    }
    public String toString(){
        return "Check information.";
    }
}
