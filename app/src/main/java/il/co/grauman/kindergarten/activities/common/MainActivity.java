package il.co.grauman.kindergarten.activities.common;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.admin.AdminMainActivity;
import il.co.grauman.kindergarten.activities.employee.EmployeeMainActivity;
import il.co.grauman.kindergarten.activities.user.UserMainActivity;
import il.co.grauman.kindergarten.bl.RestRequestImpl;
import il.co.grauman.kindergarten.models.User;
import il.co.grauman.kindergarten.models.exceptions.NotLoggedInException;
import il.co.grauman.kindergarten.services.AuthService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        //TODO: loader displayed

        try {
            AuthService.isLoggedIn(this, (@NonNull User result) -> {
                Intent intent;
                        switch (result.getRole()) {
                            case NONE:
                                intent = new Intent(MainActivity.this, LoginActivity.class);
                                break;
                            case ADMIN:
                                intent = new Intent(MainActivity.this, AdminMainActivity.class);
                                break;
                            case EMPLOYEE:
                                intent = new Intent(MainActivity.this, EmployeeMainActivity.class);
                                break;
                            case USER:
                                intent = new Intent(MainActivity.this, UserMainActivity.class);
                                break;
                            default:
                        throw new RuntimeException("Unsupported user role");
                }
                startActivity(intent);
                finish();
            });
        } catch (NotLoggedInException e){
            Toast.makeText(this, e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
