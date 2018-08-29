package il.co.grauman.kindergarten.activities.admin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.common.BaseDrawerActivity;
import il.co.grauman.kindergarten.activities.common.CalendarScheduleFragment;

public class AdminMainActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_main);
        setSupportActionBar(getToolbar());
        setTitle(R.string.admin_panel);
        navigateToFragment(new DailyScheduleAdminFragment());
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
                navigateToFragment(new DailyScheduleAdminFragment());
                break;
            // admin fragments
            case R.id.adminDailySchedule:
                navigateToFragment(new DailyScheduleAdminFragment());
                break;
            case R.id.employeeCalendar:
                navigateToFragment(new CalendarScheduleFragment());
                break;
            // employee fragments
            case R.id.adminWorkSchedule:
                navigateToFragment(new WorkScheduleAdminFragment());
                break;
            // user fragments
            case R.id.adminDailySummary:
                navigateToFragment(new DailySummaryAdminFragment());
                break;
            // user fragments
            case R.id.employeeMessages:
                navigateToFragment(new MessagesAdminFragment());
                break;
        }

        return super.onNavigationItemSelected(item);
    }
}
