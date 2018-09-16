package il.co.grauman.kindergarten.activities.common;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.bl.reports.ReportSheets;
import il.co.grauman.kindergarten.models.Agenda;
import il.co.grauman.kindergarten.models.DailyScheduleAdapter;
import il.co.grauman.kindergarten.models.DateManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DailyScheduleActivity extends BaseDrawerActivity {
    TextView date;
    RecyclerView rvSchedule;
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
        date = findViewById(R.id.title_m);
        rvSchedule = findViewById(R.id.rvSchedule);
        arrowRight = findViewById(R.id.btnRightArrow);
        arrowLeft = findViewById(R.id.btnLeftArrow);
    }

    private void setSchedule(){
        Date currentDate = dateManager.getCurrentDate();
        ReportSheets.getInstace().getDailySchedule(currentDate, new Callback<List<Agenda>>(){

            @Override
            public void onResponse(Call<List<Agenda>> call, Response<List<Agenda>> response) {

                List<Agenda> dailyActivities = response.body();

                mAdapter = new DailyScheduleAdapter(DailyScheduleActivity.this, dailyActivities);

                mRecyclerView = findViewById(R.id.rvSchedule);
                mLayoutManager = new LinearLayoutManager(DailyScheduleActivity.this);
                mRecyclerView.setLayoutManager(mLayoutManager);

                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<Agenda>> call, Throwable t) {

            }

        });

    }


}
