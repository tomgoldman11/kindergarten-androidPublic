package il.co.grauman.kindergarten.bl.references;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import il.co.grauman.kindergarten.utils.Constants;
import il.co.grauman.kindergarten.utils.SPref;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private Retrofit ret;
    private Api api;
    private static RetrofitInstance instance;

    public static RetrofitInstance getInstance() {
        if (instance == null)
            instance = new RetrofitInstance();
        return instance;
    }

    private RetrofitInstance() {
        Gson gson = new GsonBuilder().setLenient().create();
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .headers(original.headers())
                    .header("Cookie", SPref.getInstance().getString(Constants.SESSION, ""))
                    .method(original.method(), original.body())
                    .build();
            return chain.proceed(request);
        });
        ret = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();
        api = ret.create(Api.class);
    }

    public Api getApi() {
        return api;
    }

    public Retrofit getRet() {
        return this.ret;
    }
}
