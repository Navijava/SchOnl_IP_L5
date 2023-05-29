package schoolOnline.entities;

public class Academy {
    protected Integer id;
    protected String name;
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
    public String toString(){
        return "Academy";
    }
}
