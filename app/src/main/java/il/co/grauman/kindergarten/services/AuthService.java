package il.co.grauman.kindergarten.services;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;


import il.co.grauman.kindergarten.enums.Role;
import il.co.grauman.kindergarten.models.User;
import il.co.grauman.kindergarten.models.exceptions.LoginFailedException;
import il.co.grauman.kindergarten.models.exceptions.NotLoggedInException;
import java8.util.function.Consumer;

public class AuthService {

    private final static String USERNAME = "username";
    private final static String SHAREDPREF = "savedLoginSession";
    private static final String ROLE = "userRole";

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
        if(!ctx.getSharedPreferences(SHAREDPREF, Context.MODE_PRIVATE).contains("username")){
            callback.accept(new User("", "", Role.NONE));
            throw new NotLoggedInException("Not logged in");
        }

        // TODO: check if
        String username = ctx.getSharedPreferences(SHAREDPREF, Context.MODE_PRIVATE).getString(USERNAME,"");
        int intUserRole = ctx.getSharedPreferences(SHAREDPREF, Context.MODE_PRIVATE).getInt(ROLE,3);
        Role userRole = Role.values()[intUserRole];
        callback.accept(new User(username, "", userRole));
    }

    public static void loginWith(Context ctx, String username, String password, Consumer<User> callback) throws LoginFailedException {
        User tempUser = new User(username, password, Role.ADMIN);
        //TODO: Replace the "new User..." above with the line commented below when the BL function is ready.
                //BL.checkLogin(new User(username, password, Role.ADMIN));
        if (tempUser != null){
            SharedPreferences.Editor editor = ctx.getSharedPreferences(SHAREDPREF, Context.MODE_PRIVATE).edit();
            editor.putString(USERNAME, username);
            editor.putInt(ROLE, tempUser.getRole().ordinal());
            editor.commit();
            callback.accept(new User(username, password, tempUser.getRole()));
        }
        else {
            throw new LoginFailedException("Incorrect username/password");
        }
    }
}


