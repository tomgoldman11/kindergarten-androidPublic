package il.co.grauman.kindergarten.activities.common;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.bl.reports.ReportSheets;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DailySummary;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DayActivty;
import il.co.grauman.kindergarten.models.DailySchedule;
import il.co.grauman.kindergarten.models.DailyScheduleAdapter;
import il.co.grauman.kindergarten.models.DateManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DailyScheduleActivity extends BaseDrawerActivity {
    TextView date;
    RecyclerView schedule;
    ImageView arrowRight;
    ImageView arrowLeft;

    DateManager dateManager;

    private RecyclerView mRecyclerView;
    private DailyScheduleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_schedule);

        setUIElements();

        dateManager = new DateManager(date, arrowRight, arrowLeft);

        setSchedule();

    }


    private void setUIElements(){
        date = findViewById(R.id.date);
        schedule = findViewById(R.id.schedule);
        arrowRight = findViewById(R.id.rightArrow);
        arrowLeft = findViewById(R.id.leftArrow);
    }

    private void setSchedule(){
        Date currentDate = dateManager.getCurrentDate();
        ReportSheets.getInstace().getDailySchedule(currentDate, new Callback<List<DayActivty>>(){

            @Override
            public void onResponse(Call<List<DayActivty>> call, Response<List<DayActivty>> response) {

                List<DayActivty> dailyActivities = response.body();

                mAdapter = new DailyScheduleAdapter(DailyScheduleActivity.this, dailyActivities);

                mRecyclerView = findViewById(R.id.schedule);
                mLayoutManager = new LinearLayoutManager(DailyScheduleActivity.this);
                mRecyclerView.setLayoutManager(mLayoutManager);

                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<DayActivty>> call, Throwable t) {

            }

        });

    }


}
