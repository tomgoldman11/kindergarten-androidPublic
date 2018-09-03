package il.co.grauman.kindergarten.activities.user;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.admin.DailyScheduleAdminFragment;
import il.co.grauman.kindergarten.activities.admin.DailySummaryAdminFragment;
import il.co.grauman.kindergarten.activities.admin.MessagesAdminFragment;
import il.co.grauman.kindergarten.activities.admin.WorkScheduleAdminFragment;
import il.co.grauman.kindergarten.activities.common.BaseDrawerActivity;
import il.co.grauman.kindergarten.activities.common.CalendarScheduleFragment;

public class UserMainActivity extends BaseDrawerActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_main);
        setSupportActionBar(getToolbar());
        setTitle(R.string.user_panel);
    }

    @Override
    public int getDrawerMenu() {
        return R.menu.user_drawer_menu;
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        getDrawerLayout().closeDrawer(GravityCompat.START);
        switch (id) {
            // admin fragments

            case R.id.UserDrawerBtnDailySchedule:
                navigateToFragment(new DailyScheduleUserFragment());
                break;
            // user fragments
            case R.id.UserDrawerBtnCalendar:
                navigateToFragment(new UserCalendar());
                break;
            // user fragments
            case R.id.UserDrawerBtnMessage:
                navigateToFragment(new UserMessageInbox());
                break;
        }

        return super.onNavigationItemSelected(item);
    }


}
