package schoolOnline;

import schoolOnline.lection.Lection;
import schoolOnline.lection.LectionServe;

public class Test {
    public static void main(String [] arg){
        Lection lection1 = LectionServe.lectionCreate();
        Lection lection2 = LectionServe.lectionCreate();
        Lection lection3 = LectionServe.lectionCreate();
        Lection lection4 = LectionServe.lectionCreate();
        Lection lection5 = LectionServe.lectionCreate();
        System.out.println("Lection number is " + Lection.lectionCount + ".");
    }
}
