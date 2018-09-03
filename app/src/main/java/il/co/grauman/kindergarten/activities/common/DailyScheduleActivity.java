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

public class DailyScheduleActivity extends AppCompatActivity {
    TextView date;
    RecyclerView schedule;
    ImageView goToNextDay;
    ImageView goToPrevDay;

    Calendar calendar;
    Date currentDate;
    SimpleDateFormat dateFormat;

    private RecyclerView mRecyclerView;
    private DailyScheduleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_schedule);

        setUIelements();

        displayDate();

        setSchedule();

        goToNextDay.setOnClickListener(v -> setDate(1));
        goToPrevDay.setOnClickListener(v -> setDate(-1));
    }

    private void setUIelements(){
        date = findViewById(R.id.date);
        schedule = findViewById(R.id.schedule);
        goToNextDay = findViewById(R.id.rightArrow);
        goToPrevDay = findViewById(R.id.leftArrow);

        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
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

    private void setDate(int daysChange){
        calendar.add(Calendar.DAY_OF_YEAR, daysChange);
        displayDate();
    }

    private void displayDate(){
        currentDate = calendar.getTime();
        String formattedDate = dateFormat.format(currentDate);
        date.setText(formattedDate);
    }

}
