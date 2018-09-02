package il.co.grauman.kindergarten.bl.login;

import java.util.Date;

import il.co.grauman.kindergarten.bl.references.ApiImplementation;
import il.co.grauman.kindergarten.bl.references.RetrofitInstance;
import il.co.grauman.kindergarten.bl.references.StatusResponse;
import il.co.grauman.kindergarten.models.User;
import retrofit2.Callback;

public abstract class UserUpdate implements UserApi{

    @Override
    public void addUser(User user, Callback<User> callback) {
        ApiImplementation.apiImplementation(callback , ()-> RetrofitInstance.getInstance()
        .getApi().addUser(user));

    }

    @Override
    public void checkIn(Date time, String userId, Callback<StatusResponse> callback) {
        ChckInOutRequest request = new ChckInOutRequest(time,userId);
        ApiImplementation.apiImplementation(callback , ()->RetrofitInstance.getInstance()
        .getApi().checkIn(request));

    }

    @Override
    public void checkOut(Date time, String userId, Callback<StatusResponse> callback) {
        ChckInOutRequest request = new ChckInOutRequest(time,userId);
        ApiImplementation.apiImplementation(callback , ()->RetrofitInstance.getInstance()
                .getApi().checkIn(request));
    }
}
