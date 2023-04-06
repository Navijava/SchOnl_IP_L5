package schoolOnline.entities;

public class Lector extends Academy{
    private static int lectorCount;
    public Lector(){
        lectorCount++;
    }
    public static int getLectorCount(){
        return lectorCount;
    }
}
