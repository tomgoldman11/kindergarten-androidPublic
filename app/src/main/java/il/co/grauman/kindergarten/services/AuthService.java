package il.co.grauman.kindergarten.services;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;


import il.co.grauman.kindergarten.enums.Role;
import il.co.grauman.kindergarten.models.User;
import il.co.grauman.kindergarten.models.exceptions.LoginFailedException;
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

        //TODO: Change throws Exception type to more specific (custom) exception

        // TODO: check if there is session stored in the SharedPref.
        if(!ctx.getSharedPreferences("test", Context.MODE_PRIVATE).contains("username")){
            callback.accept(new User("", "", Role.NONE));
            return;
        }

        // TODO: check if


        callback.accept(new User("david", "1111", Role.ADMIN));
//        callback.onError(new Exception("NotLoggedIn"));
    }

    public static void loginWith(Context ctx, String username, String password, Consumer<User> callback) throws LoginFailedException {
        SharedPreferences.Editor editor = ctx.getSharedPreferences("test", Context.MODE_PRIVATE).edit();
        editor.putString("username", "user");
        editor.commit();
        callback.accept(new User("user", "12345", Role.ADMIN));
        throw new LoginFailedException("Incorrect username/password");
    }
}


