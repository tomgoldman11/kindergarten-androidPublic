package il.co.grauman.kindergarten.activities.common;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.enums.Role;
import il.co.grauman.kindergarten.models.exceptions.NotLoggedInException;
import il.co.grauman.kindergarten.utils.Constants;
import il.co.grauman.kindergarten.utils.SPref;

public class CalendarScheduleActivity extends BaseDrawerActivity implements CalendarView.OnDateChangeListener {

    private static final String TAG = CalendarScheduleActivity.class.getSimpleName();
    private CalendarView simpleCalendarView;
    private RecyclerView eventsRecyclerView;
    private String lastDatePicked = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        setTitle(getString(R.string.calendar));

        setupUIElements();

        simpleCalendarView.setOnDateChangeListener(this);
    }


    private void setupUIElements() {
        simpleCalendarView = findViewById(R.id.simpleCalendarView);
        simpleCalendarView.setFirstDayOfWeek(1);
        simpleCalendarView.setDate(Calendar.getInstance().getTimeInMillis());
        eventsRecyclerView = findViewById(R.id.rec);
    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
        Log.d(TAG, "onSelectedDayChange() "+ year + "/" + month + "/" + dayOfMonth);
        if(String.format("%d/%d/%d",year,month,dayOfMonth).equals(lastDatePicked)){
            if(eventsRecyclerView.getVisibility() == View.GONE){
                eventsRecyclerView.setVisibility(View.VISIBLE);
            } else {
                eventsRecyclerView.setVisibility(View.GONE);
            }
        } else{
            eventsRecyclerView.setVisibility(View.VISIBLE);
        }
        lastDatePicked = year + "/" + month + "/" + dayOfMonth;
    }


}
