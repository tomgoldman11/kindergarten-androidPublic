package il.co.grauman.kindergarten.bl.references;

import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.bl.login.LoginRequest;
import il.co.grauman.kindergarten.bl.shifts.shiftRequests.AdminShiftsRequest;
import il.co.grauman.kindergarten.bl.shifts.shiftModels.DailyShift;
import il.co.grauman.kindergarten.bl.shifts.shiftRequests.UpdateShiftRequset;
import il.co.grauman.kindergarten.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {
    public final String BASE_URL ="http://10.0.2.2:9080/Authentication/webapi/";

    @POST ("myresource/login")
    Call<User> userLogin(@Body LoginRequest req);

    @POST ("myresource/scheduale")
    Call<List<DailyShift>> getWorkSchedule(@Body AdminShiftsRequest shift);

    @POST("myresource/admin_scheduale")
    Call<List<DailyShift>> getWorkSchedule(@Body Date day);

    @POST("myresource/add_shift")
    Call<DailyShift> addShift(@Body DailyShift dailyShift);

    @POST("myresource/remove_shift")
    Call<StatusResponse> removeShift(@Body DailyShift dailyShift);

    @POST("myresource/update_shift")
    Call<StatusResponse> updateShift(@Body UpdateShiftRequset updateShiftRequset);


}
