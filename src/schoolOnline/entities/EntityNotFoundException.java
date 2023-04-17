package schoolOnline.entities;

public class EntityNotFoundException extends Exception{
    public String getMessage(){
        return "No such id.";
    }
    public String toString(){
        return "Attention! Wrong choice.";
    }
}
