package schoolOnline.entities;

public enum Task {
    TASK1(1),
    TASK2(2),
    TASK3(3),
    TASK4(4),
    TASK5(5);
    Task(){}
    int id;
    Task(int id){
        this.id = id;
    }
    static public Task getByInt(int rnd){
        for(Task tsk : Task.values()){
            if(tsk.id == rnd){
                return tsk;
            }
        }
        return TASK1;
    }
}
