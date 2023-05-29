package schoolOnline.entities;

public enum TempLastnames {
    SMITH(1),
    BROWN(2),
    GREEN(3),
    BLACK(4),
    WHITE(5);

    TempLastnames(int id){
        this.id = id;
    }
    int id;
    public static TempLastnames getTempLastName(int id){
        for(TempLastnames tempLastname : TempLastnames.values()){
            if(tempLastname.id == id) return tempLastname;
        }
        return WHITE;
    }
}
