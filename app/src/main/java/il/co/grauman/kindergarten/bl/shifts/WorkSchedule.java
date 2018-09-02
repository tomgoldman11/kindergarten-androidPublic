package il.co.grauman.kindergarten.bl.shifts;

import java.util.Date;
import java.util.List;

import retrofit2.Callback;

public interface WorkSchedule {
    void getWorkSchedule(String userId , Date day, Callback<WeeklyShifts> callback);
    void getWorkSchedule(Date day, Callback<List<WeeklyShifts>> callback);
}
