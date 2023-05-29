package human;

public class Person implements Personality {
    public Person(){};
    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }
    int age;
    String name;

    @Override
    public void introduce(){
        System.out.println(((name == null) ? "" : ("My name is " + name + ". ")) + "I am student. Let's study new material.");
    }
}
