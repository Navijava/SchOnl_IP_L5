package schoolOnline.entities;

public enum TempNames {
    POLE(1),
    AMANDA(2),
    JOHN(3),
    VICTORIA(4),
    JACK(5);
    TempNames(){}
    TempNames(int tempId){
        this.tempId = tempId;
    }
    int tempId;

    public static TempNames getTempName(int tempId){
        for (TempNames tempNames : TempNames.values()){
            if(tempNames.tempId == tempId) return tempNames;
        }
        return JACK;
    }
}
