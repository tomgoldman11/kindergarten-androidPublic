package il.co.grauman.kindergarten.bl.shifts;

import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.bl.shifts.shiftModels.DailyShift;
import retrofit2.Callback;

public interface WorkScheduleApi {
    void getWorkSchedule(String userId , Date day, Callback<List<DailyShift>> callback);
    void getWorkSchedule(Date day, Callback<List<DailyShift>> callback);
    }
