package il.co.grauman.kindergarten.activities.user;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.common.BaseDrawerActivity;

public class UserMainActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_main);
        setSupportActionBar(getToolbar());
        setTitle(R.string.user_panel);
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

    @Override
    public int getDrawerMenu() {
        return R.menu.user_drawer_menu;
    }
}
