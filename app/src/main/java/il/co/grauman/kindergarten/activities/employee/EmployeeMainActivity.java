package il.co.grauman.kindergarten.activities.employee;

import android.os.Bundle;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.common.BaseDrawerActivity;

public class EmployeeMainActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_main);
        setSupportActionBar(getToolbar());
        setTitle(R.string.employee_panel);
    }

    @Override
    public int getDrawerMenu() {
        return R.menu.employee_drawer_menu;
    }
}
