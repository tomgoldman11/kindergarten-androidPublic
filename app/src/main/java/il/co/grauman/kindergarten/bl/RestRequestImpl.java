package il.co.grauman.kindergarten.bl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import il.co.grauman.kindergarten.models.User;
import retrofit2.Call;
import retrofit2.Callback;
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
        call.enqueue(callback);
    }

    //@Override
    //public void getUserDetails(Callback<User> callback) {

    //}
}
