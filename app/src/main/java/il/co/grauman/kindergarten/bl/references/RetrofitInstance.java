package il.co.grauman.kindergarten.bl.references;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private Retrofit ret;
    private static RetrofitInstance instance;
    public static RetrofitInstance getInstance(){
        if(instance == null)
            instance = new RetrofitInstance();
        return instance;
    }

    private RetrofitInstance(){
        Gson gson = new GsonBuilder().setLenient().create();
        ret = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public Retrofit getRet(){
        return this.ret;
    }
}
