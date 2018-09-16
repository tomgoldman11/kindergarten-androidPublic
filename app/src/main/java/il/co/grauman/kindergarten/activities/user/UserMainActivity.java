package il.co.grauman.kindergarten.activities.user;

import android.os.Bundle;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.common.BaseDrawerActivity;

public class UserMainActivity extends BaseDrawerActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        setTitle(R.string.user_panel);
    }

    @Override
    public int getDrawerMenu() {
        return R.menu.user_drawer_menu;
    }

}
