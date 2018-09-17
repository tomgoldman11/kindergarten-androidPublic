package il.co.grauman.kindergarten.activities.admin;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.bl.calender.Calender;
import il.co.grauman.kindergarten.bl.calender.DayEvent;
import il.co.grauman.kindergarten.bl.calender.EventType;
import il.co.grauman.kindergarten.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEventToCalendarActivity extends AppCompatActivity {
    private static final String TAG = "AddEventToCalendar";
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private String datePicked;
    private int pickedYear;
    private int pickedMonth;
    private int pickedDay;
    private EventType pickedEventType;
    private Time pickedFromHour;
    private Time pickedToHour;


    private TextView selectedDate;
    private TextInputLayout eventTitleContainer;
    private EditText eventTitleEditText;
    private EditText eventDescEditText;
    private Spinner eventTypeSpinner;
    private Spinner eventFromSpinner;
    private Spinner eventToSpinner;
    private Button saveEventButton;
    private ProgressBar saveEventProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event_calendar);
        setupUIElements();

        selectedDate.setOnClickListener(v -> {
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(AddEventToCalendarActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                    mDateSetListener, year, month, day);
            Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });

        mDateSetListener = (datePicker, year, month, day) -> {
            Log.d(TAG, "onDateSet() mm/dd/yyy: " + (month + 1) + "/" + day + "/" + year);
            datePicked = year + "/" + (month + 1) + "/" + day;
            pickedYear = year;
            pickedMonth = month;
            pickedDay = day;
            selectedDate.setText(datePicked);
        };

        saveEventButton.setOnClickListener(v -> {
            eventTitleContainer.setError(null);
            if (eventTitleEditText.getText().toString().isEmpty()) {
                eventTitleContainer.setError(getString(R.string.must_not_be_empty));
                return;
            }

            if (pickedEventType == null) {
                displayErrorAlert(getString(R.string.select_event_type_error));
                return;
            }

            if (pickedFromHour == null) {
                displayErrorAlert(getString(R.string.select_from_hour_error));
                return;
            }

            if (pickedToHour == null) {
                displayErrorAlert(getString(R.string.select_to_hour_error));
                return;
            }


            Calendar datePicked = Calendar.getInstance();
            datePicked.set(Calendar.YEAR, pickedYear);
            datePicked.set(Calendar.MONTH, pickedMonth);
            datePicked.set(Calendar.DAY_OF_MONTH, pickedDay);

            DayEvent event = new DayEvent(
                    eventTitleEditText.getText().toString(),
                    eventDescEditText.getText().toString(),
                    new java.sql.Date(datePicked.getTimeInMillis()),
                    pickedEventType,
                    pickedFromHour,
                    pickedToHour
            );


            setLoader(true);
            Calender.getInstance().addEventToCalender(event, new Callback<DayEvent>() {
                @Override
                public void onResponse(@NonNull Call<DayEvent> call, @NonNull Response<DayEvent> response) {
                    setLoader(false);
                    Intent returnIntent = new Intent();
                    DayEvent newEvent = response.body();
                    assert newEvent != null;
                    returnIntent.putExtra(Constants.EVENT_ADDED_RESULT, newEvent.getId());
                    setResult(Activity.RESULT_OK, returnIntent);
                    finishActivity(Constants.ADD_EVENT_TO_CALENDAR_REQUEST);
                }

                @Override
                public void onFailure(@NonNull Call<DayEvent> call, @NonNull Throwable t) {
                    Log.e(TAG, "addEventToCalender()", t);
                    setLoader(false);
                    displayErrorAlert(getString(R.string.error_adding_event));
                }
            });
        });
    }

    private void setLoader(boolean visible) {
        saveEventButton.setText(visible ? "" : getString(R.string.add_new));
        saveEventProgress.setVisibility(visible ? View.VISIBLE : View.GONE);
        saveEventButton.setEnabled(!visible);
        selectedDate.setEnabled(!visible);
        eventTitleEditText.setEnabled(!visible);
        eventDescEditText.setEnabled(!visible);
        eventTypeSpinner.setEnabled(!visible);
        eventFromSpinner.setEnabled(!visible);
        eventToSpinner.setEnabled(!visible);
    }

    private void displayErrorAlert(String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(AddEventToCalendarActivity.this).create();
        alertDialog.setTitle(getString(R.string.error));
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, getString(R.string.ok), (dialog, which) -> dialog.dismiss());
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {
        setResult(Activity.RESULT_CANCELED);
        finish();
    }

    private void setupUIElements() {
        setSupportActionBar(findViewById(R.id.toolbar));
        setTitle(R.string.add_new_event_title);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ((Toolbar) findViewById(R.id.toolbar)).setNavigationOnClickListener(view -> onBackPressed());

        selectedDate = findViewById(R.id.selectedDate);
        eventTitleContainer = findViewById(R.id.eventTitleContainer);
        eventTitleEditText = findViewById(R.id.eventTitleEditText);
        eventDescEditText = findViewById(R.id.eventDescEditText);
        eventTypeSpinner = findViewById(R.id.eventTypeSpinner);
        eventFromSpinner = findViewById(R.id.eventFromSpinner);
        eventToSpinner = findViewById(R.id.eventToSpinner);
        saveEventButton = findViewById(R.id.saveEventButton);
        saveEventProgress = findViewById(R.id.saveEventProgress);

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        selectedDate.setText(String.format(getString(R.string.date_format),
                String.valueOf(currentYear),
                String.valueOf(currentMonth + 1),
                String.valueOf(currentDay)));

        List<String> types = new ArrayList<>();
        types.add(getString(R.string.event_type_name_normal));
        types.add(getString(R.string.event_type_name_birthday));
        types.add(getString(R.string.event_type_name_holiday));
        types.add(getString(R.string.event_type_name_party));
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eventTypeSpinner.setAdapter(adapter);
        eventTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pickedEventType = EventType.values()[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                pickedEventType = null;
            }
        });

        List<String> hours_24 = generate24Hours();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, hours_24);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eventFromSpinner.setAdapter(adapter);
        eventFromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pickedFromHour = Time.valueOf(hours_24.get(position) + ":00");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                pickedFromHour = null;
            }
        });

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, hours_24);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eventToSpinner.setAdapter(adapter);
        eventToSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pickedToHour = Time.valueOf(hours_24.get(position) + ":00");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                pickedToHour = null;
            }
        });

    }

    private List<String> generate24Hours() {
        List<String> times = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            times.add(String.format("%s:00", i));
            times.add(String.format("%s:15", i));
            times.add(String.format("%s:30", i));
            times.add(String.format("%s:45", i));
        }
        return times;
    }
}
