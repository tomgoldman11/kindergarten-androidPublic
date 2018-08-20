package il.co.grauman.kindergarten.activities.common;

import android.annotation.SuppressLint;
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
import il.co.grauman.kindergarten.utils.Util;

@SuppressLint("Registered")
public class BaseDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActionBarDrawerToggle toggle;
    private ImageView drawerUserPhoto;
    private TextView drawerUserName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Util.setRtl(this, "he");
    }

    @NonNull
    public DrawerLayout getDrawerLayout() {
        throw new RuntimeException("Must override getDrawerLayout");
    }

    @NonNull
    public NavigationView getNavigationView() {
        throw new RuntimeException("Must override getNavigationView");
    }

    @NonNull
    public Toolbar getToolbar() {
        throw new RuntimeException("Must override getToolbar");
    }

    public int getDrawerMenu() {
        throw new RuntimeException("Must override getDrawerMenu");
    }


    protected void setupDrawerMenuItems() {
        DrawerLayout drawer = getDrawerLayout();
        NavigationView navigationView = getNavigationView();
        Toolbar toolbar = getToolbar();

        getNavigationView().inflateMenu(getDrawerMenu());
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(true);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        drawerUserPhoto = navigationView.getHeaderView(0).findViewById(R.id.drawer_user_photo);
        drawerUserName = navigationView.getHeaderView(0).findViewById(R.id.drawer_user_name);

        setupUserDetails();
    }

    private void setupUserDetails() {
        // TODO: load user picture to 'drawerUserPhoto'
        // TODO: load username to 'drawerUserName'
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // TODO: Handle navigation view item clicks here.
        int id = item.getItemId();

        getDrawerLayout().closeDrawer(GravityCompat.START);

        return true;
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
