package entities;

public class Lecture {
    public Lecture(){}
    public Lecture(int id, String name){
        this.id = id;
        this.name = name;
    }
    private int id;
    private String name;
    public String toString(){
        return "lecture's name is " + this.name;
    }

}
