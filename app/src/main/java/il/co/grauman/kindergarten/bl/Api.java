package il.co.grauman.kindergarten.bl;

import il.co.grauman.kindergarten.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {
    public final String BASE_URL ="http://10.0.2.2:9080/Authentication/webapi/";

    @POST ("myresource/login")
    Call<User> userLogin(@Body LoginRequest req);
}