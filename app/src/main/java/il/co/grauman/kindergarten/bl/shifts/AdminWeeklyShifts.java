package il.co.grauman.kindergarten.bl.shifts;

import java.util.List;

public class AdminWeeklyShifts {
    List<EmployeeWeeklyShifts> workSchedule;

    public AdminWeeklyShifts(List<EmployeeWeeklyShifts> workSchedule) {
        this.workSchedule = workSchedule;
    }

    public List<EmployeeWeeklyShifts> getWorkSchedule() {
        return workSchedule;
    }

//    public void setWorkSchedule(List<EmployeeWeeklyShifts> workSchedule) {
//        this.workSchedule = workSchedule;
//    }
}
