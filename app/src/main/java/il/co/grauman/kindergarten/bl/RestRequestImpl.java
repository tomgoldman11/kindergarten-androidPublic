package il.co.grauman.kindergarten.bl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.models.User;
import java8.util.function.Supplier;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

    private  <T> void apiImplementation(Callback<T> callback, Supplier<Call<T>> func) {
        Call<T> call = func.get();
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if(response.code() == 200) {
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
            public void onFailure(Call<T> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }

    @Override
    public void userLogin(String username, String password, Callback<User> callback) {
        Api api = ret.create(Api.class);
        apiImplementation(callback, () -> api.userLogin(new LoginRequest(username, password)));
    }

    @Override
    public void getWorkSchedule(String userId, Date day, Callback<WeeklySchedule> callback){
        Api api = ret.create(Api.class);
        apiImplementation(callback, () -> api.getWorkSchedule(new Schedule(userId, day)));
    }

    @Override
    public void getWorkSchedule(Date day, Callback<List<WeeklySchedule>> callback) {
        Api api = ret.create(Api.class);
        apiImplementation(callback, () -> api.getWorkSchedule(day));
    }


    //@Override
    //public void getUserDetails(Callback<User> callback) {

    //}
}
