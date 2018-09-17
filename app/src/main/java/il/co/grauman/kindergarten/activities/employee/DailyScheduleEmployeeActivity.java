package il.co.grauman.kindergarten.activities.employee;

import android.os.Bundle;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.common.BaseDrawerActivity;

public class DailyScheduleEmployeeActivity extends BaseDrawerActivity {

    @Override
    protected int getDrawerItemId() {
        return R.id.employeeDailyScheduleMenu;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_schedule_employee);
    }
}
