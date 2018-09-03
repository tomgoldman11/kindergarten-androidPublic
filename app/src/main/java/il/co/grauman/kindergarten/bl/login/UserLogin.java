package il.co.grauman.kindergarten.bl.login;

import il.co.grauman.kindergarten.bl.references.Api;
import il.co.grauman.kindergarten.bl.references.ApiImplementation;
import il.co.grauman.kindergarten.bl.references.RetrofitInstance;
import il.co.grauman.kindergarten.models.User;
import retrofit2.Callback;

public class UserLogin implements LoginApi {
    public static void userLogin(String username, String password, Callback<User> callback) {
        ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                .getApi().userLogin(new LoginRequest(username, password)));
    }
}
