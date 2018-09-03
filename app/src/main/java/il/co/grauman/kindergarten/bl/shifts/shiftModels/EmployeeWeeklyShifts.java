package il.co.grauman.kindergarten.bl.shifts.shiftModels;

import java.util.List;

//not used by the REST ,, REST used Lists instead

public class EmployeeWeeklyShifts {
    List<DailyShift> workWeek;
    String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public EmployeeWeeklyShifts(List<DailyShift> workWeek, String userId) {
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
