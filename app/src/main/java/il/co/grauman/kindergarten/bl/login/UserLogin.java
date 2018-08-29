package il.co.grauman.kindergarten.bl.login;

import il.co.grauman.kindergarten.bl.references.Api;
import il.co.grauman.kindergarten.bl.references.ApiImplementation;
import il.co.grauman.kindergarten.bl.references.RetrofitInstance;
import il.co.grauman.kindergarten.models.User;
import retrofit2.Callback;

public class UserLogin implements LoginApi {
    public void userLogin(String username, String password, Callback<User> callback) {
        Api api = RetrofitInstance.getInstance().getRet().create(Api.class);
        ApiImplementation.apiImplementation(callback, () -> api.userLogin(new LoginRequest(username, password)));
    }
}
