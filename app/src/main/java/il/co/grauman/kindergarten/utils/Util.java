package il.co.grauman.kindergarten.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;

import java.util.Locale;

import il.co.grauman.kindergarten.activities.common.BaseDrawerActivity;

public class Util {
    private static final String TAG = Util.class.getSimpleName();

    @SuppressWarnings("deprecation")
    private static void setSystemLocaleLegacy(Configuration config, Locale locale) {
        config.locale = locale;
        try {
            config.setLayoutDirection(locale);
        } catch (Exception e) {
            Log.e(TAG, "setSystemLocaleLegacy()", e);
        }
    }

    @TargetApi(Build.VERSION_CODES.N)
    private static void setSystemLocale(Configuration config, Locale locale) {
        config.setLocale(locale);
        config.setLayoutDirection(locale);
    }

    public static void setRtl(Context context, String languageCode) {
        Resources res = context.getResources();
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = res.getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            setSystemLocale(config, locale);
        } else {
            setSystemLocaleLegacy(config, locale);
        }
        res.updateConfiguration(config,
                context.getResources().getDisplayMetrics());
    }
}
