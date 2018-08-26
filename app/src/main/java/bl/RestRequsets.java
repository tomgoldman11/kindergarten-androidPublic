package bl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import il.co.grauman.kindergarten.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestRequsets {
    Gson gson = new GsonBuilder().setLenient().create();
    private static Retrofit ret = new Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    public static User userLogin (String username , String password){
        Api api = ret.create(Api.class);
        Call<User> call = api.userLogin(new LoginRequset(username,password));
        User userResult;
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                userResult = response.body();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

    }
}
