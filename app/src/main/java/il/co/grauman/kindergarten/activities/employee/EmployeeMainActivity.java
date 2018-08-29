package il.co.grauman.kindergarten.activities.employee;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.admin.DailyScheduleAdminFragment;
import il.co.grauman.kindergarten.activities.common.BaseDrawerActivity;
import il.co.grauman.kindergarten.activities.common.CalendarScheduleFragment;

public class EmployeeMainActivity extends BaseDrawerActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_main);
        setSupportActionBar(getToolbar());
        setTitle(R.string.employee_panel);
        navigateToFragment(new DailyScheduleAdminFragment());
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
            case R.id.btnDailyScheduleEmployee:
                navigateToFragment(new DailyScheduleEmployeeFragment());
                break;
            case R.id.btnCalendarScheduleEmployee:
                navigateToFragment(new CalendarScheduleFragment());
                break;
            // employee fragments
            case R.id.btnWorkScheduleEmployee:
                navigateToFragment(new WorkScheduleEmployeeFragment());
                break;
            // user fragments
            case R.id.btnMessagesEmployee:
                navigateToFragment(new MessagesEmployeeFragment());
                break;
        }

        return super.onNavigationItemSelected(item);
    }

}
