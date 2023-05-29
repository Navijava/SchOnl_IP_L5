package schoolOnline.repositories;

import schoolOnline.entities.Person;

import java.util.ArrayList;

public class PersonRepository {
    private static ArrayList<Person> personList = new ArrayList<>();
    public static ArrayList<Person> getPersonList(){
        return personList;
    }
    public static boolean addPerson(Person person){
        if(personList.stream()
                .noneMatch(prsn -> prsn.getEmail().equals(person.getEmail()))){
            personList.add(person);
            return true;
        } else return false;
    }
}
