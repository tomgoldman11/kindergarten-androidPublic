package il.co.grauman.kindergarten.services;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;


import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.enums.Role;
import il.co.grauman.kindergarten.models.User;
import il.co.grauman.kindergarten.models.exceptions.LoginFailedException;
import il.co.grauman.kindergarten.models.exceptions.NotLoggedInException;
import il.co.grauman.kindergarten.utils.Constants;
import java8.util.function.Consumer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthService {

    /**
     * check if there is session stored in the SharedPref.
     * create async request and check if the session is valid.
     * get the last updated logged user details from the server.
     * if isLoggedIn return the User details with callback.onResult
     * else, call the onError function
     *
     * @param callback BasicCallback implementation
     */
    public static void isLoggedIn(Context ctx, @NonNull Consumer<User> callback) throws Exception {

        //TODO: Change throws Exception type to more specific (custom) exception V

        // TODO: check if there is session stored in the SharedPref.
        if (!ctx.getSharedPreferences(Constants.SHAREDPREF, Context.MODE_PRIVATE).contains(Constants.USERNAME)) {
            callback.accept(new User("", "", Role.NONE));
            throw new NotLoggedInException(ctx.getResources().getString(R.string.user_not_logged_in));
        }

        String username = ctx.getSharedPreferences(Constants.SHAREDPREF, Context.MODE_PRIVATE).getString(Constants.USERNAME, "");
        int intUserRole = ctx.getSharedPreferences(Constants.SHAREDPREF, Context.MODE_PRIVATE).getInt(Constants.ROLE, 3);
        Role userRole = Role.values()[intUserRole];
        callback.accept(new User(username, "", userRole));
    }

}


