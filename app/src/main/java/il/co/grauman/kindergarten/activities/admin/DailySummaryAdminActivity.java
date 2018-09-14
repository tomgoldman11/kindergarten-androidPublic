package il.co.grauman.kindergarten.activities.admin;

import android.view.View;

import il.co.grauman.kindergarten.activities.common.DailySummaryActivity;

public class DailySummaryAdminActivity extends DailySummaryActivity {
    View addEventBtn;

    DailySummaryAdminActivity() {
        super();
    }




    @Override
    protected void setRoleBasedUIElemnts() {


        addEventBtn.setVisibility(View.VISIBLE);

        addEventBtn.setOnClickListener(v -> navigateToFragment(new AddEventFragment()));
    }
}
