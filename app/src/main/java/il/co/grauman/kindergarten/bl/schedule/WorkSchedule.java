package il.co.grauman.kindergarten.bl.schedule;

import java.util.Date;
import java.util.List;

import retrofit2.Callback;

public interface WorkSchedule {
    void getWorkSchedule(String userId , Date day, Callback<WeeklySchedule> callback);
    void getWorkSchedule(Date day, Callback<List<WeeklySchedule>> callback);
}
