package il.co.grauman.kindergarten.bl.shifts;

import java.util.Date;
import java.util.List;

import retrofit2.Callback;

public interface WorkSchedule {
    void getWorkSchedule(String userId , Date day, Callback<EmployeeWeeklyShifts> callback);
    void getWorkSchedule(Date day, Callback<AdminWeeklyShifts> callback);
}
