package il.co.grauman.kindergarten.bl.references;

import java.io.IOException;

import java8.util.function.Supplier;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiImplementation{

    public static  <T> void apiImplementation(Callback<T> callback, Supplier<Call<T>> func) {
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
}
