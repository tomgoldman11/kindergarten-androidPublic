package il.co.grauman.kindergarten.activities.admin;

import android.os.Bundle;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.common.BaseDrawerActivity;

public class AdminMainActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_main);
        setSupportActionBar(getToolbar());
        setTitle(R.string.admin_panel);
        navigateToFragment(new AdminHomeFragment());
    }


    @Override
    public int getDrawerMenu() {
        return R.menu.admin_drawer_menu;
    }
}
