package schoolOnline.entities;

public class Academy {
    protected int id;
    protected String name;
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
    public String toString(){
        return "Academy";
    }
}
