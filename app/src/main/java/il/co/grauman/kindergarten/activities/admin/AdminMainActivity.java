package il.co.grauman.kindergarten.activities.admin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.common.BaseDrawerActivity;

public class AdminMainActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_main);
        setSupportActionBar(getToolbar());
        setTitle(R.string.admin_panel);
    }


    @NonNull
    @Override
    public DrawerLayout getDrawerLayout() {
        return findViewById(R.id.drawer_layout);
    }

    @NonNull
    @Override
    public NavigationView getNavigationView() {
        return findViewById(R.id.nav_view);
    }

    @NonNull
    @Override
    public Toolbar getToolbar() {
        return findViewById(R.id.toolbar);
    }

    @NonNull
    @Override
    public int getDrawerMenu() {
        return R.menu.admin_drawer_menu;
    }
}
