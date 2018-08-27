package il.co.grauman.kindergarten.activities.employee;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
=======
>>>>>>> 4981b493fca21b259bb483932d6ff9bc768228b9

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.common.BaseDrawerActivity;
import il.co.grauman.kindergarten.activities.common.LoginActivity;

public class EmployeeMainActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
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
=======
        setContentView(R.layout.activity_drawer_main);
        setSupportActionBar(getToolbar());
        setTitle(R.string.employee_panel);
>>>>>>> 4981b493fca21b259bb483932d6ff9bc768228b9
    }

    @Override
    public int getDrawerMenu() {
        return R.menu.employee_drawer_menu;
    }
}
