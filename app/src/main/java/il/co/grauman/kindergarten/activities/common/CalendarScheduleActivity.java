package il.co.grauman.kindergarten.activities.common;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TwoLineListItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.bl.calender.Calender;
import il.co.grauman.kindergarten.bl.calender.Event;
import il.co.grauman.kindergarten.bl.calender.YearSchedule;
import il.co.grauman.kindergarten.enums.Role;
import il.co.grauman.kindergarten.utils.Constants;
import il.co.grauman.kindergarten.utils.SPref;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CalendarScheduleActivity extends BaseDrawerActivity implements CalendarView.OnDateChangeListener {

    private static final String TAG = CalendarScheduleActivity.class.getSimpleName();
    private CalendarView simpleCalendarView;
    private ListView eventsListView;
    private FloatingActionButton adminAddEvents;
    private String lastDatePicked = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        setTitle(getString(R.string.calendar));
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupUIElements();

        EventsForDate(Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

        simpleCalendarView.setOnDateChangeListener(this);
    }

    public void setEventsListView(ArrayList<Event> events) {
        ArrayAdapter<Event> adapter = new ArrayAdapter<Event>(this,android.R.layout.simple_list_item_2,events){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView text1 = view.findViewById(android.R.id.text1);
                TextView text2 = view.findViewById(android.R.id.text2);

                text1.setText(events.get(position).getEvent());
                text2.setText(events.get(position).getDescription());
                return view;
            }
        };
        eventsListView.setAdapter(adapter);
    }

    private void EventsForDate(int year, int month, int day) {

        (new Calender()).getCalender(year, new Callback<YearSchedule>() {
            @Override
            public void onResponse(Call<YearSchedule> call,@NonNull Response<YearSchedule> response) {

            }

            @Override
            public void onFailure(Call<YearSchedule> call, Throwable t) {

            }
        });
    }


    private void setupUIElements() {
        simpleCalendarView = findViewById(R.id.simpleCalendarView);
        simpleCalendarView.setFirstDayOfWeek(1);
        simpleCalendarView.setDate(Calendar.getInstance().getTimeInMillis());
        eventsListView = findViewById(R.id.lvEvents);
        adminAddEvents = findViewById(R.id.fabAddEvent);
        if (Role.values()[SPref.getInstance().getInt(Constants.ROLE,3)]==Role.ADMIN){
            adminAddEvents.setVisibility(View.VISIBLE);
        } else {
            adminAddEvents.setVisibility(View.GONE);
        }
        eventsListView.setVisibility(View.VISIBLE);
        Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/M/d");
        lastDatePicked = format.format(today);
        Log.d(TAG, "SetupUIElements() "+ lastDatePicked);
    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
        Log.d(TAG, "onSelectedDayChange() "+ year + "/" + (month+1) + "/" + dayOfMonth);
        if(String.format("%d/%d/%d",year,month+1,dayOfMonth).equals(lastDatePicked)){
            if(eventsListView.getVisibility() == View.GONE){
                eventsListView.setVisibility(View.VISIBLE);
                EventsForDate(year,month,dayOfMonth);
            } else {
                eventsListView.setVisibility(View.GONE);
            }
        } else{
            eventsListView.setVisibility(View.VISIBLE);
        }
        lastDatePicked = year + "/" + (month+1) + "/" + dayOfMonth;
    }

}
