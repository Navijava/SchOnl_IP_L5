package schoolOnline.entities;

public class AdditionalMaterial{
    private Integer id;
    private String name;
    public String commonName;
    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
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
