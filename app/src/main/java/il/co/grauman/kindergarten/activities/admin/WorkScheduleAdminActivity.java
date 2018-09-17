package il.co.grauman.kindergarten.activities.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.common.BaseDrawerActivity;

public class WorkScheduleAdminActivity extends BaseDrawerActivity {

    @Override
    protected int getDrawerItemId() {
        return R.id.adminWorkScheduleMenu;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_schedule_admin);
    }
}
