package il.co.grauman.kindergarten.bl.schedule;

import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.bl.references.Api;
import il.co.grauman.kindergarten.bl.references.ApiImplementation;
import il.co.grauman.kindergarten.bl.references.RetrofitInstance;
import retrofit2.Callback;

public class WorkWeekSchedule implements WorkSchedule {
    @Override
    public void getWorkSchedule(String userId, Date day, Callback<WeeklySchedule> callback){
        Api api = RetrofitInstance.getInstance().getRet().create(Api.class);
        ApiImplementation.apiImplementation(callback, () -> api.getWorkSchedule(new Schedule(userId, day)));
    }

    @Override
    public void getWorkSchedule(Date day, Callback<List<WeeklySchedule>> callback) {
        Api api = RetrofitInstance.getInstance().getRet().create(Api.class);
        ApiImplementation.apiImplementation(callback, () -> api.getWorkSchedule(day));
    }
}
