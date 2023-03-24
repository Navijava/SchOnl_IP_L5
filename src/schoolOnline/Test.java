package schoolOnline;

import schoolOnline.entitiesUtils.CommonUtil;
import schoolOnline.entitiesUtils.LectureUtil;

public class Test {
    public static void main(String [] arg){

        LectureUtil.lectureCreate(6);

        CommonUtil.findInfo();

        LectureUtil.lectureCreate();

    }
}
