package il.co.grauman.kindergarten.activities.common;

import android.annotation.SuppressLint;
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
import il.co.grauman.kindergarten.enums.Role;
import il.co.grauman.kindergarten.models.User;
import il.co.grauman.kindergarten.services.AuthService;
import il.co.grauman.kindergarten.utils.Constants;
import il.co.grauman.kindergarten.utils.SPref;
import il.co.grauman.kindergarten.utils.Util;
import java8.util.function.Consumer;

@SuppressLint("Registered")
public abstract class BaseDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    protected abstract int getDrawerItemId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_drawer_main);
        Util.setRtl(this, "he");
        setSupportActionBar(getToolbar());
        AuthService.isLoggedIn(user -> {
            if (user.getCategory() == Role.NONE) {
                SPref.getInstance().clearAll();
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
        });
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
            default:
                return -1;
        }
    }

    public void setBackButton(boolean visible) {

    }

    protected void setupDrawerMenuItems() {
        DrawerLayout drawer = getDrawerLayout();
        NavigationView navigationView = getNavigationView();
        Toolbar toolbar = getToolbar();

        getNavigationView().getMenu().clear();
        int menuResource = getDrawerMenu();
        getNavigationView().inflateMenu(R.menu.header_drawer_menu);
        if (menuResource != -1) {
            getNavigationView().inflateMenu(menuResource);
        }
        getNavigationView().inflateMenu(R.menu.footer_drawer_menu);
        getNavigationView().getMenu().findItem(getDrawerItemId()).setCheckable(true).setChecked(true);


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
            case R.id.dailySummaryMenu:
                navigateToActivity(DailySummaryActivity.class);
                break;
            case R.id.calendarMenu:
                navigateToActivity(CalendarScheduleActivity.class);
                break;
            case R.id.messagesMenu:
                navigateToActivity(MessagesActivity.class);
                break;
            case R.id.logoutMenu:
                SPref.getInstance().clearAll();
                navigateToActivity(MainActivity.class);
                break;

            // admin
            case R.id.adminDailySummaryMenu:
                break;
            case R.id.adminDailyScheduleMenu:
                break;
            case R.id.adminWorkScheduleMenu:
                break;
            // employee
            case R.id.employeeDailyScheduleMenu:
                break;
            case R.id.employeeWorkScheduleMenu:
                break;
        }

        return true;
    }

    protected void navigateToActivity(Class c) {
        startActivity(new Intent(BaseDrawerActivity.this, c));
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
