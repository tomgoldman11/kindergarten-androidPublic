package il.co.grauman.kindergarten.bl;

import il.co.grauman.kindergarten.models.User;
import retrofit2.Callback;

public interface RestRequest {
    void userLogin(String username, String password, Callback<User> callback);
    //void getUserDetails(Callback<User> callback);
}
