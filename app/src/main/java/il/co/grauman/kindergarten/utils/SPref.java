package il.co.grauman.kindergarten.utils;

import android.content.Context;
import android.content.SharedPreferences;

import il.co.grauman.kindergarten.App;
import il.co.grauman.kindergarten.activities.common.LoginActivity;

public class SPref {

    private static SPref instance;
    private SharedPreferences sharedPreferences;

    synchronized public static SPref getInstance() {
        if (instance == null) {
            instance = new SPref();
        }
        return instance;
    }

    private SPref() {
        sharedPreferences = App.getInstance().getSharedPreferences(Constants.SHAREDPREF, Context.MODE_PRIVATE);
    }

    public String getString(String key, String defValue) {
        return sharedPreferences.getString(key, defValue);
    }

    public void putString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public Integer getInt(String key, Integer defValue) {
        return sharedPreferences.getInt(key, defValue);
    }

    public void putInt(String key, Integer value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public boolean contains(String key) {
        return sharedPreferences.contains(key);
    }

    public void clearAll() {
        sharedPreferences.edit().clear().apply();
    }
}
