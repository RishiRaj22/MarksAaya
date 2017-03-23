package coding.quizzaciously.nitpchanakyaunofficial.datahandler;

/**
 * Created by Raj on 23-12-2016.
 */

public class AttendanceValue {
    private String name;
    private int totalClasses;
    private int attendedClasses;
    public AttendanceValue(String name,int totalClasses,int attendedClasses)
    {
        this.name=name;
        this.totalClasses=totalClasses;
        this.attendedClasses=attendedClasses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalClasses() {
        return totalClasses;
    }

    public void setTotalClasses(int totalClasses) {
        this.totalClasses = totalClasses;
    }

    public int getAttendedClasses() {
        return attendedClasses;
    }

    public void setAttendedClasses(int attendedClasses) {
        this.attendedClasses = attendedClasses;
    }
}
