package coding.quizzaciously.nitpchanakyaunofficial.datahandler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raj on 23-12-2016.
 */

public class SubjectAttendanceValue extends AttendanceValue {
    private List<AttendanceValue> attendanceValues;
    public SubjectAttendanceValue(String name, int totalClasses, int attendedClasses) {
        this(name, totalClasses, attendedClasses,new ArrayList<AttendanceValue>());
    }
    public SubjectAttendanceValue(String name, int totalClasses,int attendedClasses,List<AttendanceValue> attendanceValues)
    {
        super(name,totalClasses,attendedClasses);
        this.attendanceValues=attendanceValues;
    }
    public AttendanceValue getChildAt(int index)
    {
        return attendanceValues.get(index);
    }
    public void addChild(AttendanceValue attendanceValue)
    {
        attendanceValues.add(attendanceValue);
    }
    public int size(){
        return attendanceValues.size();
    }

}
