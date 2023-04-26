package schoolOnline.entities;

import java.util.Random;

public class AdditionalMaterial implements Comparable<AdditionalMaterial>{
    AdditionalMaterial(){
        this.id = ++id;
    }
    public AdditionalMaterial(Integer lectureId){
        this.id = ++additionalMaterialCount;
        this.lectureId = lectureId;
        this.resourceType = ResourceType.getByInt(new Random().nextInt(1, 4));
    }
    private static int additionalMaterialCount;
    private Integer id;
    private String name;
    private Integer lectureId;
    private ResourceType resourceType;
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
    public void setLectureId(Integer lectureId){
        this.lectureId = lectureId;
    }
    public Integer getLectureId(){
        return this.lectureId;
    }
    public void setResourceType(ResourceType resourceType){
        this.resourceType = resourceType;
    }
    public ResourceType getResourceType(){
        return this.resourceType;
    }
    private int date;
    public void setDate(int date){
        this.date = date;
    }
    public int getDate(){
        return date;
    }
    public String toString(){
        return "\nAdditional material id is " + this.id
                + ", lecture's id is " + this.lectureId +
                ", its resource type - " + this.resourceType + ". ";
    }

    @Override
    public int compareTo(AdditionalMaterial addMat) {
        return this.id - addMat.id;
    }
}
