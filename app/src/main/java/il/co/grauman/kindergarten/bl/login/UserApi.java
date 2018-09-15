package il.co.grauman.kindergarten.bl.login;

import java.util.Date;

import il.co.grauman.kindergarten.bl.references.StatusResponse;
import il.co.grauman.kindergarten.models.User;
import retrofit2.Callback;

public interface UserApi {
    void userLogin(String username, String password, Callback<User> callback);
    void getLogedUserr(Callback<User> callback);
    void addUser(User user , Callback<User> callback);
    void checkIn(Date time , String userId , Callback<StatusResponse> callback);
    void checkOut(Date time , String userId , Callback<StatusResponse> callback);
    void getLogedout(Callback<StatusResponse> callback);

}
