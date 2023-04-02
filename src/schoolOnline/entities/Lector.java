package schoolOnline.entities;

public class Lector {
    private static int lectorCount;
    private int id;
    private String name;
    public Lector(){
        lectorCount++;
    }
    public static int getLectorCount(){
        return lectorCount;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
