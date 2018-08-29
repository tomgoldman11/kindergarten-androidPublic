package il.co.grauman.kindergarten.bl;

import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.models.User;
import retrofit2.Callback;

public interface RestRequest {
    void userLogin(String username, String password, Callback<User> callback);
    void getWorkSchedule(String userId , Date day, Callback<WeeklySchedule> callback);
    void getWorkSchedule(Date day, Callback<List<WeeklySchedule>> callback);
}
