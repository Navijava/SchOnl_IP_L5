package schoolOnline.entities;

public class AdditionalMaterial{
    private int id;
    private String name;
    public String commonName;
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
    private int date;
    public void setDate(int date){
        this.date = date;
    }
    public int getDate(){
        return date;
    }
}
