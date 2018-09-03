package il.co.grauman.kindergarten.bl.shifts.shiftModels;

import java.util.List;

//not used by the REST ,, REST used Lists instead

public class AdminWeeklyShifts {
    List<DailyShift> workSchedule;

    public AdminWeeklyShifts(List<DailyShift> workSchedule) {
        this.workSchedule = workSchedule;
    }

    public List<DailyShift> getWorkSchedule() {
        return workSchedule;
    }

//    public void setWorkSchedule(List<EmployeeWeeklyShifts> workSchedule) {
//        this.workSchedule = workSchedule;
//    }
}
