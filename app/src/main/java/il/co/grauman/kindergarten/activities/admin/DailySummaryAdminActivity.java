package il.co.grauman.kindergarten.activities.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.common.BaseDrawerActivity;
import il.co.grauman.kindergarten.activities.common.DailySummaryActivity;

public class DailySummaryAdminActivity extends DailySummaryActivity {

    @Override
    protected void setRoleBasedUIElements() {

        addEventBtn.setVisibility(View.VISIBLE);

        addEventBtn.setOnClickListener(v -> navigateToFragment(new AddEventFragment()));
    }
}
