package il.co.grauman.kindergarten.activities.common;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.models.DailySchedule;
import il.co.grauman.kindergarten.models.DailyScheduleAdapter;
import il.co.grauman.kindergarten.models.DateManager;

public class DailyScheduleActivity extends AppCompatActivity {
    TextView date;
    RecyclerView schedule;
    ImageView arrowRight;
    ImageView arrowLeft;

    private RecyclerView mRecyclerView;
    private DailyScheduleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_schedule);

        setUIElements();

        DateManager dateManager = new DateManager(date, arrowRight, arrowLeft);

        setSchedule();

    }

    private void setUIElements(){
        date = findViewById(R.id.date);
        schedule = findViewById(R.id.schedule);
        arrowRight = findViewById(R.id.rightArrow);
        arrowLeft = findViewById(R.id.leftArrow);
    }

    private void setSchedule(){
        ArrayList<DailySchedule> dailyActivities = new ArrayList<DailySchedule>();

        //TO-DO: ADD THE FUNCTION THAT GETS DATA FROM BL FOR THE DAILY SCHEDULE
        // STATIC DATA FOR NOW
        dailyActivities.add(new DailySchedule("8","אוכל"));
        dailyActivities.add(new DailySchedule("9","פיפי"));
        dailyActivities.add(new DailySchedule("10","סקראם"));

        mAdapter = new DailyScheduleAdapter(this, dailyActivities);

        mRecyclerView = findViewById(R.id.schedule);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mAdapter);

    }


}
