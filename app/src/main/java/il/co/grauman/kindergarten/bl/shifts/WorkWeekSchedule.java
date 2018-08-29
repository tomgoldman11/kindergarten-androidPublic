package il.co.grauman.kindergarten.bl.shifts;

import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.bl.references.ApiImplementation;
import il.co.grauman.kindergarten.bl.references.RetrofitInstance;
import retrofit2.Callback;

public class WorkWeekSchedule implements WorkSchedule {
    @Override
    public void getWorkSchedule(String userId, Date day, Callback<WeeklyShifts> callback){
       ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
               .getApi().getWorkSchedule(new ShiftRequest(userId, day)));
    }

    @Override
    public void getWorkSchedule(Date day, Callback<List<WeeklyShifts>> callback) {
        ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                .getApi().getWorkSchedule(day));
    }
}