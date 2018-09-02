package il.co.grauman.kindergarten.activities.common;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import il.co.grauman.kindergarten.activities.admin.MessagesAdminActivity;
import il.co.grauman.kindergarten.activities.admin.WorkScheduleAdminActivity;
import il.co.grauman.kindergarten.enums.Role;
import il.co.grauman.kindergarten.utils.Constants;
import il.co.grauman.kindergarten.utils.SPref;
import il.co.grauman.kindergarten.utils.Util;

@SuppressLint("Registered")
public abstract class BaseDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActionBarDrawerToggle toggle;
    private ImageView drawerUserPhoto;
    private TextView drawerUserName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_drawer_main);
        Util.setRtl(this, "he");
        setSupportActionBar(getToolbar());
    }

    @Override
    public void setContentView(int resId){
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
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        // display the icon on the toolbar
        toggle.setDrawerIndicatorEnabled(true);
        // add event listener to drawer to detect onClick to open th drawer (left view)
        drawer.addDrawerListener(toggle);
        // sync animated Hamburger to the drawer state
        toggle.syncState();
        // set listener to on item click in the drawer -> this should implement the interface
        navigationView.setNavigationItemSelectedListener(this);

        // set up ui elements
        drawerUserPhoto = navigationView.getHeaderView(0).findViewById(R.id.drawerUserPhoto);
        drawerUserName = navigationView.getHeaderView(0).findViewById(R.id.drawerUserName);
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
            // admin fragments
            case R.id.adminDailySchedule:
                navigateToActivity(new DailyScheduleAdminActivity());
                break;
            case R.id.userCalendar:
            case R.id.employeeCalendar:
            case R.id.adminCalendar:
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
