package il.co.grauman.kindergarten.activities.employee;

import android.os.Bundle;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.common.BaseDrawerActivity;

public class WorkScheduleEmployeeActivity extends BaseDrawerActivity {

    @Override
    protected int getDrawerItemId() {
        return R.id.employeeWorkScheduleMenu;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_schedule_employee);
    }
}
