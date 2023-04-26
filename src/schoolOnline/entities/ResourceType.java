package schoolOnline.entities;

public enum ResourceType {
    URL(1),
    VIDEO(2),
    BOOK(3);
    int id;
    ResourceType(){}
    ResourceType(int id){
        this.id = id;
    }

    static public ResourceType getByInt(int rnd){
        for(ResourceType restyp : ResourceType.values()){
            if(restyp.id == rnd) {
                return restyp;
            }
        }
        return ResourceType.URL;
    }

}
