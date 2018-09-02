package il.co.grauman.kindergarten.activities.admin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.common.BaseDrawerActivity;
import il.co.grauman.kindergarten.activities.common.CalendarScheduleActivity;

public class AdminMainActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_main);
        setSupportActionBar(getToolbar());
        setTitle(R.string.admin_panel);
        //navigateToActivity(new DailyScheduleAdminActivity());
    }


    @Override
    public int getDrawerMenu() {
        return R.menu.admin_drawer_menu;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        getDrawerLayout().closeDrawer(GravityCompat.START);
        switch (id) {
            // admin fragments
            case R.id.adminHome:
                navigateToActivity(new AdminMainActivity());
                break;
            // admin fragments
            case R.id.adminDailySchedule:
                navigateToActivity(new DailyScheduleAdminActivity());
                break;
            case R.id.employeeCalendar:
                navigateToActivity(new CalendarScheduleActivity());
                break;
            // employee fragments
            case R.id.adminWorkSchedule:
                navigateToActivity(new WorkScheduleAdminActivity());
                break;
            // user fragments
            case R.id.adminDailySummary:
                navigateToActivity(new DailySummaryAdminActivity());
                break;
            // user fragments
            case R.id.employeeMessages:
                navigateToActivity(new MessagesAdminActivity());
                break;
        }

        return super.onNavigationItemSelected(item);
    }
}
