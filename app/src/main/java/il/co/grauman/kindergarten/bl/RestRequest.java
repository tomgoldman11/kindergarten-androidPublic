package il.co.grauman.kindergarten.bl;

import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.models.User;
import retrofit2.Callback;

public interface RestRequest {
    void userLogin(String username, String password, Callback<User> callback);
    void showWorkSchedule(String userId , Date day, Callback<WeeklySchedualeObject> callback);
    void showWorkSchedule(Date day, Callback<List<WeeklySchedualeObject>> callback);
}
