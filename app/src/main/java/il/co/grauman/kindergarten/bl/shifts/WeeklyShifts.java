package il.co.grauman.kindergarten.bl.shifts;

import java.util.List;

public class WeeklyShifts {
    List<DailyShift> workWeek;
    String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public WeeklyShifts(List<DailyShift> workWeek, String userId) {
        this.workWeek = workWeek;
        this.userId = userId;
    }

    public List<DailyShift> getWorkWeek() {
        return workWeek;
    }

    public void setWorkWeek(List<DailyShift> workWeek) {
        this.workWeek = workWeek;
    }
}
