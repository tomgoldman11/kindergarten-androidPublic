package il.co.grauman.kindergarten.activities.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.models.User;
import il.co.grauman.kindergarten.services.AuthService;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // force rtl layout
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AuthService.isLoggedIn((@NonNull User result) -> {
            Intent intent;
            switch (result.getCategory()) {
                case ADMIN:
                case EMPLOYEE:
                case USER:
                    intent = new Intent(MainActivity.this, DailySummaryActivity.class);
                    break;
                default:
                    intent = new Intent(MainActivity.this, LoginActivity.class);
            }
            startActivity(intent);
            finish();
        });
    }
}
