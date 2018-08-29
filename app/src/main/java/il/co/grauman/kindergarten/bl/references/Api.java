package il.co.grauman.kindergarten.bl.references;

import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.bl.login.LoginRequest;
import il.co.grauman.kindergarten.bl.schedule.Schedule;
import il.co.grauman.kindergarten.bl.schedule.WeeklySchedule;
import il.co.grauman.kindergarten.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {
    public final String BASE_URL ="http://10.0.2.2:9080/Authentication/webapi/";

    @POST ("myresource/login")
    Call<User> userLogin(@Body LoginRequest req);

    @POST ("myresource/scheduale")
    Call<WeeklySchedule> getWorkSchedule(@Body Schedule schedule);

    @POST("myresource/adminScheduale")
    Call<List<WeeklySchedule>> getWorkSchedule(@Body Date day);

}
