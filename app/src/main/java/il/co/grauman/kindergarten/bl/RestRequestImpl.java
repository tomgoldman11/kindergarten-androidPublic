package il.co.grauman.kindergarten.bl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import il.co.grauman.kindergarten.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RestRequestImpl implements RestRequest {
    private Retrofit ret;
    private static RestRequest instance;
    public static RestRequest getInstance(){
        if(instance == null)
            instance = new RestRequestImpl();
        return instance;
    }

    private RestRequestImpl(){
        Gson gson = new GsonBuilder().setLenient().create();
        ret = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Override
    public void userLogin(String username, String password, Callback<User> callback) {
        Api api = ret.create(Api.class);
        Call<User> call = api.userLogin(new LoginRequest(username, password));
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.code() == 200){
                    callback.onResponse(call, response);
                }else {
                    try {
                        callback.onFailure(call, new Exception(response.errorBody().string()));
                    } catch (IOException e) {
                        callback.onFailure(call, e);
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                 callback.onFailure(call, t);
            }
        });
    }

    //@Override
    //public void getUserDetails(Callback<User> callback) {

    //}
}
