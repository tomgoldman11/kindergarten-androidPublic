package il.co.grauman.kindergarten.bl.login;

import il.co.grauman.kindergarten.models.User;
import retrofit2.Callback;

public interface LoginApi {
    void userLogin(String username, String password, Callback<User> callback);
}
