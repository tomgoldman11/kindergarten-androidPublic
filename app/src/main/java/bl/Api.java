package bl;

import il.co.grauman.kindergarten.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {
    public final String BASE_URL ="";

    @POST ("/login")
    Call<User> userLogin(@Body LoginRequset req);
}
