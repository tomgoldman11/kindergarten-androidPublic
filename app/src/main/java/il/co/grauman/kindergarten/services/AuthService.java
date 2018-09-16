package il.co.grauman.kindergarten.services;

import android.support.annotation.NonNull;

import il.co.grauman.kindergarten.enums.Role;
import il.co.grauman.kindergarten.models.User;
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
    public static void isLoggedIn(@NonNull Consumer<User> callback) {
        if (!SPref.getInstance().contains(Constants.USERNAME) || !SPref.getInstance().contains(Constants.SESSION)) {
            callback.accept(new User("", "", Role.NONE));
            return;
        }
        String username = SPref.getInstance().getString(Constants.USERNAME, "");
        Role userRole = Role.values()[SPref.getInstance().getInt(Constants.ROLE, 3)];
        callback.accept(new User(username, "", userRole));
    }

}


