package il.co.grauman.kindergarten.activities.employee;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.common.BaseDrawerActivity;
import il.co.grauman.kindergarten.activities.common.LoginActivity;

public class EmployeeMainActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_main_screen);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu., menu); //your file name
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        Intent intent = new Intent(EmployeeMainActivity.this, LoginActivity.class);
        switch (item.getItemId()) {
            case R.id.btnWorkSchedule:
                intent = new Intent(EmployeeMainActivity.this, LoginActivity.class);
                break;
            case R.id.btnDailySchedule:
                intent = new Intent(EmployeeMainActivity.this, LoginActivity.class);
                break;
            case R.id.btnAnnualSchedule:
                intent = new Intent(EmployeeMainActivity.this, LoginActivity.class);
                break;
            case R.id.btnEmployeeMessages:
                intent = new Intent(EmployeeMainActivity.this, LoginActivity.class);
                break;
        }
            startActivity(intent);
            finish();
            return true;
    }

    @Override
    @NonNull
    public DrawerLayout getDrawerLayout() {
        return findViewById(R.id.drawer_layout);
    }

    @Override
    @NonNull
    public NavigationView getNavigationView() {
        return findViewById(R.id.nav_view);
    }

}
