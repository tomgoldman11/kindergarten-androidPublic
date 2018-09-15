package il.co.grauman.kindergarten.bl.login;

import java.util.Date;

import il.co.grauman.kindergarten.bl.references.ApiImplementation;
import il.co.grauman.kindergarten.bl.references.RetrofitInstance;
import il.co.grauman.kindergarten.bl.references.StatusResponse;
import il.co.grauman.kindergarten.models.User;
import retrofit2.Callback;

public class  UserUpdate  {

    private static UserApi instance;

    public static UserApi getInstance() {
        if (instance == null) {
            instance = new UserApi() {
                @Override
                public void userLogin(String username, String password, Callback<User> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().userLogin(new LoginRequest(username, password)));
                }
                public void getLogedUserr( Callback<User> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getLogedUserr());
                }


                @Override
                public void addUser(User user, Callback<User> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().addUser(user));

                }

                @Override
                public void checkIn(Date time, String userId, Callback<StatusResponse> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().checkIn(new ChckInOutRequest(time, userId)));

                }

                @Override
                public void checkOut(Date time, String userId, Callback<StatusResponse> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().checkOut(new ChckInOutRequest(time, userId)));
                }

                @Override
                public void getLogedout(Callback<StatusResponse> callback){
                    ApiImplementation.apiImplementation(callback, ()-> RetrofitInstance.getInstance()
                    .getApi().getLogedout());
                }
            };

        }
        return instance;
    }
}
