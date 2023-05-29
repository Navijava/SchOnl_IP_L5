package schoolOnline.repositories;

import schoolOnline.entities.Lecture;
import java.util.Arrays;

public class TypedRepository <E>{

    E [] typeRepository;
    TypedRepository(){
    }
    public TypedRepository(E[] e){
        typeRepository = e;
    }

    void setTypeRepository(E[] e){
        typeRepository = e;
    }
    public int size(){
        if (isNull()){
            System.out.println("There is no repository yet.");
            return 0;
        }
        int count = 0;
        for(int i = 0; i < typeRepository.length; i++){
            if(typeRepository[i] != null){
                count++;
            }
        }
        return count;
    }
    public boolean isEmpty(){
        if (isNull()){
            System.out.println("There is no repository yet.");
            return false;
        }
        for(int i = 0; i < typeRepository.length; i++){
            if(typeRepository[i] != null){
                return false;
            }
        }
        return true;
    }

    public E get (int index){
        if (isNull()){
            System.out.println("There is no repository yet.");
            return null;
        }
        if(index >= typeRepository.length || index < 0){
            System.out.println("Incorrect lecture index.");
            return null;
        }
        if(typeRepository[index] == null)  {
            System.out.println("Lecture doesn't exist.");
            return null;}
        return typeRepository[index];
    }

    public void add(E element){
        if(!checkSpace()){
            System.out.println("There is no free space.");
            typeRepository = increaseSpace();
            //typeRepository = Arrays.copyOf(typeRepository, typeRepository.length *3 / 2 + 1);
            //return;
        }
        for(int i = 0; i < typeRepository.length; i++){
            if(typeRepository[i] == null){
                typeRepository[i] = element;
                System.out.println("Added.");
                return;
            }
        }
    }

    public void add(int index, E element) {
        if(typeRepository[index] == null){
            typeRepository[index] = element;
            System.out.println("Added.");
            return;
        }
        if(!checkSpace()){
            System.out.println("There is no free space.");
            typeRepository = increaseSpace();
        }
        E [] typeRepositoryRes = (E []) new Object[typeRepository.length + 1];
        for(int i = 0; i < typeRepository.length; i++){
            if(i < index) {
                typeRepositoryRes[i] = typeRepository[i];
            }
            if(i == index) {
                typeRepositoryRes[i] = element;
                typeRepositoryRes[i + 1] = typeRepository[i];
                System.out.println("Added by index.");
            }
            if(i > index) {
                typeRepositoryRes[i + 1] = typeRepository[i];
            }
        }
        typeRepository = typeRepositoryRes;
    }

    public void remove(int index){
        if(index < 0 || index > typeRepository.length){
            System.out.println("Incorrect index.");
            return;
        }
        if(typeRepository[index] == null){
            System.out.println("There is nothing to remove.");
            return;
        }
        typeRepository[index] = null;
        System.out.println("Successfully removed.");

    }

    private boolean isNull(){
        if(typeRepository == null){
            return true;
        }
        return false;
    }

    private boolean checkSpace(){
        for (int i = 0; i < typeRepository.length; i++){
            if(typeRepository[i] == null) return true;
        }
        return false;
    }
    private E [] increaseSpace(){
        E [] typeRepositoryRes = (E []) new Object [(typeRepository.length * 3) / 2 + 1];
        for(int i = 0; i < typeRepository.length; i++){
            typeRepositoryRes[i] = typeRepository[i];
        }
        return typeRepositoryRes;
    }

    public int capacity(){
        return typeRepository.length;
    }

}
