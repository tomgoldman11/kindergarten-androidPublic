package il.co.grauman.kindergarten.activities.common;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.admin.AddEventFragment;
import il.co.grauman.kindergarten.bl.reports.ReportSheets;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DailySummary;
import il.co.grauman.kindergarten.enums.Role;
import il.co.grauman.kindergarten.models.DateManager;
import il.co.grauman.kindergarten.models.DailySummaryAdapter;
import il.co.grauman.kindergarten.utils.Constants;
import il.co.grauman.kindergarten.utils.SPref;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DailySummaryActivity extends BaseDrawerActivity {
    TextView date;
    ScrollView summary;
    ImageView arrowRight;
    ImageView arrowLeft;
    TextView description;
    LinearLayout DynamicImagesLayout;
    protected Button addEventBtn;
    DateManager dateManager;

    private RecyclerView mRecyclerView;
    private DailySummaryAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_summary);

        setUIElements();

        setRoleBasedUIElemnts();

        dateManager = new DateManager(date, arrowRight, arrowLeft);

        setSummary();
    }

    protected void setRoleBasedUIElemnts() {

    }

    protected void navigateToFragment(Fragment newFragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.subLayout, newFragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void setUIElements(){
        date = findViewById(R.id.date);
        summary = findViewById(R.id.summary);
        description = findViewById(R.id.description);
        arrowRight = findViewById(R.id.rightArrow);
        arrowLeft = findViewById(R.id.leftArrow);
        addEventBtn = findViewById(R.id.btnNewEvent);
        DynamicImagesLayout = (LinearLayout) findViewById(R.id.linearLayoutDynamicImages);
    }

    private void setSummary(){
        Date currentDate = dateManager.getCurrentDate();
        DailySummary newEvent;
        ReportSheets.getInstace().getDailySummary(currentDate, new Callback<DailySummary>() {
            @Override
            public void onResponse(Call<DailySummary> call, Response<DailySummary> response) {
                DailySummary newEvent = response.body();

                // get data from dailysummary class object

                String eventDescription = newEvent.getEvent();
                List<String> eventImages = (List<String>) newEvent.getPictures();

                description.setText(eventDescription);

                for(int i = 0 ; i < eventImages.size(); i++) {
                    ImageView currentImage = new ImageView(DailySummaryActivity.this);
                    DynamicImagesLayout.addView(currentImage);
                    Picasso.get().load(eventImages.get(i).toString()).into(currentImage);
                }
            }

            @Override
            public void onFailure(Call<DailySummary> call, Throwable t) {

            }
        });


    }


}
