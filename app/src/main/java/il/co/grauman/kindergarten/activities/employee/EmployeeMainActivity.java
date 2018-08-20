package il.co.grauman.kindergarten.activities.employee;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.common.BaseDrawerActivity;

public class EmployeeMainActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_main);

        setSupportActionBar(getToolbar());
        setTitle("Employee Panel");
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
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
        return R.menu.employee_drawer_menu;
    }
}
