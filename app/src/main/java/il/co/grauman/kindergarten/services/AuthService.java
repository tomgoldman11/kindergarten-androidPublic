package il.co.grauman.kindergarten.services;

import android.content.Context;
import android.support.annotation.NonNull;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.enums.Role;
import il.co.grauman.kindergarten.models.User;
import il.co.grauman.kindergarten.models.exceptions.NotLoggedInException;
import il.co.grauman.kindergarten.utils.Constants;
import il.co.grauman.kindergarten.utils.SPref;
import java8.util.function.Consumer;

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
        SPref.getInstance().putString(Constants.USERNAME, "david");
        SPref.getInstance().putInt(Constants.ROLE, Role.USER.ordinal());

        if (!SPref.getInstance().contains(Constants.USERNAME)) {
            callback.accept(new User("", "", Role.USER));
            throw new NotLoggedInException(ctx.getString(R.string.user_not_logged_in));
        }
        String username = SPref.getInstance().getString(Constants.USERNAME, "");
        Role userRole = Role.values()[SPref.getInstance().getInt(Constants.ROLE, 3)];
        callback.accept(new User(username, "", userRole));
    }

}


