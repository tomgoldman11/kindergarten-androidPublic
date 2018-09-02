package il.co.grauman.kindergarten.activities.employee;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.admin.DailyScheduleAdminActivity;
import il.co.grauman.kindergarten.activities.common.BaseDrawerActivity;
import il.co.grauman.kindergarten.activities.common.CalendarScheduleActivity;

public class EmployeeMainActivity extends BaseDrawerActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_main);
        setSupportActionBar(getToolbar());
        setTitle(R.string.employee_panel);
        navigateToActivity(new DailyScheduleAdminActivity());
    }
    @Override
    public int getDrawerMenu() {
        return R.menu.employee_drawer_menu;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        getDrawerLayout().closeDrawer(GravityCompat.START);
        switch (id) {
            // admin fragments
            case R.id.employeeHome:
                navigateToActivity(new DailyScheduleEmployeeActivity());
                break;
            // admin fragments
            case R.id.employeeDailySchedule:
                navigateToActivity(new DailyScheduleEmployeeActivity());
                break;
            case R.id.employeeCalendar:
                navigateToActivity(new CalendarScheduleActivity());
                break;
            // employee fragments
            case R.id.employeeWorkSchedule:
                navigateToActivity(new WorkScheduleEmployeeActivity());
                break;
            // user fragments
            case R.id.employeeMessages:
                navigateToActivity(new MessagesEmployeeActivity());
                break;
        }

        return super.onNavigationItemSelected(item);
    }

}
