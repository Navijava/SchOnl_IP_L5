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
    public String toString(){
        return "Academy";
    }
}
