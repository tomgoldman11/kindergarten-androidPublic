package il.co.grauman.kindergarten.bl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.models.User;
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

    @Override
    public void userLogin(String username, String password, Callback<User> callback) {
        Api api = ret.create(Api.class);
        Call<User> call = api.userLogin(new LoginRequest(username, password));
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
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
            public void onFailure(Call<User> call, Throwable t) {
                 callback.onFailure(call, t);
            }
        });
    }

    public void showWorkSchedule(String userId, Date day, Callback<WeeklySchedualeObject> callback){
        Api api = ret.create(Api.class);
        Call<WeeklySchedualeObject> call = api.showWorkSchedule(new Schedule(userId, day));
        call.enqueue(new Callback<WeeklySchedualeObject>(){
            @Override
            public void onResponse(Call<WeeklySchedualeObject> call, Response<WeeklySchedualeObject> response) {
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
            public void onFailure(Call<WeeklySchedualeObject> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }

    @Override
    public void showWorkSchedule(Date day, Callback<List<WeeklySchedualeObject>> callback) {
        Api api = ret.create(Api.class);
        Call<List<WeeklySchedualeObject>> call = api.showWorkSchedule(day);
        call.enqueue(new Callback<List<WeeklySchedualeObject>>(){
            @Override
            public void onResponse(Call<List<WeeklySchedualeObject>> call, Response<List<WeeklySchedualeObject>> response) {
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
            public void onFailure(Call<List<WeeklySchedualeObject>> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }


    //@Override
    //public void getUserDetails(Callback<User> callback) {

    //}
}
