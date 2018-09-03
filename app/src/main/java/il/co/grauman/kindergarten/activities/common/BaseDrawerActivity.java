package il.co.grauman.kindergarten.activities.common;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.admin.AdminMainActivity;
import il.co.grauman.kindergarten.activities.admin.DailyScheduleAdminActivity;
import il.co.grauman.kindergarten.activities.admin.DailySummaryAdminActivity;
import il.co.grauman.kindergarten.activities.admin.WorkScheduleAdminActivity;
import il.co.grauman.kindergarten.activities.employee.DailyScheduleEmployeeActivity;
import il.co.grauman.kindergarten.activities.employee.EmployeeMainActivity;
import il.co.grauman.kindergarten.activities.employee.MessagesEmployeeActivity;
import il.co.grauman.kindergarten.activities.employee.WorkScheduleEmployeeActivity;
import il.co.grauman.kindergarten.activities.user.UserMainActivity;
import il.co.grauman.kindergarten.enums.Role;
import il.co.grauman.kindergarten.utils.Constants;
import il.co.grauman.kindergarten.utils.SPref;
import il.co.grauman.kindergarten.utils.Util;

@SuppressLint("Registered")
public abstract class BaseDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_drawer_main);
        Util.setRtl(this, "he");
        setSupportActionBar(getToolbar());
    }

    @Override
    public void setContentView(int resId) {
        getLayoutInflater().inflate(resId, findViewById(R.id.subLayout), true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.setupDrawerMenuItems();
    }

    @NonNull
    protected DrawerLayout getDrawerLayout() {
        return findViewById(R.id.drawerLayout);
    }

    @NonNull
    private NavigationView getNavigationView() {
        return findViewById(R.id.navView);
    }

    @NonNull
    public Toolbar getToolbar() {
        return findViewById(R.id.toolbar);
    }

    public int getDrawerMenu() {
        switch (Role.values()[SPref.getInstance().getInt(Constants.ROLE, Role.NONE.ordinal())]) {
            case ADMIN:
                return R.menu.admin_drawer_menu;
            case EMPLOYEE:
                return R.menu.employee_drawer_menu;
            case USER:
                return R.menu.user_drawer_menu;
            default:
                throw new IllegalStateException();
        }
    }


    protected void setupDrawerMenuItems() {
        DrawerLayout drawer = getDrawerLayout();
        NavigationView navigationView = getNavigationView();
        Toolbar toolbar = getToolbar();

        getNavigationView().inflateMenu(getDrawerMenu());

        // init Action Bar Drawer Toggle [Hamburger]
        // link toggle -> drawer left view
        // lint toggle -> toolbar upper view (to know where to put the icon)
        // other strings is for accessibility purpose
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        // display the icon on the toolbar
        toggle.setDrawerIndicatorEnabled(true);
        // add event listener to drawer to detect onClick to open th drawer (left view)
        drawer.addDrawerListener(toggle);
        // sync animated Hamburger to the drawer state
        toggle.syncState();
        // set listener to on item click in the drawer -> this should implement the interface
        navigationView.setNavigationItemSelectedListener(this);

        // set up ui elements
        ImageView drawerUserPhoto = navigationView.getHeaderView(0).findViewById(R.id.drawerUserPhoto);
        TextView drawerUserName = navigationView.getHeaderView(0).findViewById(R.id.drawerUserName);
        setupUserDetails();
    }

    private void setupUserDetails() {
        // TODO: load user picture to 'drawerUserPhoto'
        // TODO: load username to 'drawerUserName'
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
            case R.id.adminDailySchedule:
                navigateToActivity(new DailyScheduleActivity());
                break;
            case R.id.adminCalendar:
                navigateToActivity(new CalendarScheduleActivity());
                break;
            case R.id.adminWorkSchedule:
                navigateToActivity(new WorkScheduleAdminActivity());
                break;
            case R.id.adminDailySummary:
                navigateToActivity(new DailySummaryAdminActivity());
                break;


            case R.id.userHome:
                navigateToActivity(new UserMainActivity());
                break;


            case R.id.employeeHome:
                navigateToActivity(new EmployeeMainActivity());
                break;
            case R.id.employeeCalendar:
                break;
            case R.id.employeeDailySchedule:
                navigateToActivity(new DailyScheduleEmployeeActivity());
                break;
            case R.id.employeeWorkSchedule:
                navigateToActivity(new WorkScheduleEmployeeActivity());
                break;
            case R.id.employeeMessages:
                navigateToActivity(new MessagesEmployeeActivity());
                break;
        }

        return true;
    }

    protected void navigateToActivity(Activity newIntent) {
        Intent intent = new Intent(BaseDrawerActivity.this, newIntent.getClass());

        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        if (getDrawerLayout().isDrawerOpen(GravityCompat.START)) {
            getDrawerLayout().closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
