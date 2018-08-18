package il.co.grauman.kindergarten.activities.employee;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.common.BaseDrawerActivity;

public class EmployeeMainActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_main);
    }

    @Override
    @NonNull
    public DrawerLayout getDrawerLayout() {
        return findViewById(R.id.drawer_layout);
    }

    @Override
    @NonNull
    public NavigationView getNavigationView() {
        return findViewById(R.id.nav_view);
    }

}
