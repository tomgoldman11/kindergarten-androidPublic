package il.co.grauman.kindergarten.activities.common;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.admin.AddEventToCalendarActivity;
import il.co.grauman.kindergarten.bl.calender.Calender;
import il.co.grauman.kindergarten.bl.calender.DayEvent;
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
    private int lastYearPicked = 0;
    private List<DayEvent> yearlyEvents;
    private ArrayList<DayEvent> eventsForDate;

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
        eventsForSpecificDate(Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

        simpleCalendarView.setOnDateChangeListener(this);
        adminAddEvents.setOnClickListener(v -> {
            //Intent addEventToCalendar = new Intent(this, AddEventToCalendarActivity.class);
            //startActivityForResult(addEventToCalendar,Constants.ADD_EVENT_TO_CALENDAR_REQUEST);
        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if(resultCode == RESULT_OK) {
//            Toast.makeText(this,getResources().getString(R.string.event_added_to_calendar),Toast.LENGTH_LONG);
//        } else {
//            //Toast.makeText(this,getResources().getString())
//        }
//    }

    public void setEventsListView(ArrayList<DayEvent> events) {
        ArrayAdapter<DayEvent> adapter = new ArrayAdapter<DayEvent>(this,android.R.layout.simple_list_item_2, android.R.id.text1, events){
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

    private void eventsForSpecificDate(int year, int month, int day) {
        Log.d(TAG,"EventsForSpecificDate()" + year + "/" + (month+1) + "/" +day);
        if(year != lastYearPicked){
            lastYearPicked = year;
            (new Calender()).getCalender(lastYearPicked, new Callback<List<DayEvent>>() {
                @Override
                public void onResponse(Call<List<DayEvent>> call, Response<List<DayEvent>> response) {
                    yearlyEvents = response.body();
                    eventsForSpecificDate(year,month,day);
                }

                @Override
                public void onFailure(Call<List<DayEvent>> call, Throwable t) {
                    requestFailed(t.getMessage());
                }
            });

        } else {
            Calendar selectedDate = Calendar.getInstance();
            selectedDate.set(Calendar.YEAR, year);
            selectedDate.set(Calendar.MONTH, month);
            selectedDate.set(Calendar.DAY_OF_MONTH, day);
            eventsForDate = new ArrayList<>();
            for(int i = 0; i< yearlyEvents.size(); i++){
                DayEvent newEvent = yearlyEvents.get(i);
                Calendar eventDate = Calendar.getInstance();
                eventDate.setTime(newEvent.getDay());
                if(selectedDate.equals(eventDate)){
                    eventsForDate.add(newEvent);
                }
            }
            setEventsListView(eventsForDate);
        }
    }

    private void requestFailed(String errorMessage) {
        Toast.makeText(this, /*errorMessage +*/ getResources().getString(R.string.try_again), Toast.LENGTH_LONG).show();
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
                eventsForSpecificDate(year,month,dayOfMonth);
            } else {
                eventsListView.setVisibility(View.GONE);
            }
        } else{
            eventsListView.setVisibility(View.VISIBLE);
        }
        lastDatePicked = year + "/" + (month+1) + "/" + dayOfMonth;
    }
}
