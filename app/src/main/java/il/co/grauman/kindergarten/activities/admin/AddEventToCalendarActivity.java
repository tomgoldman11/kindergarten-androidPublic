package il.co.grauman.kindergarten.activities.admin;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.bl.calender.Calender;
import il.co.grauman.kindergarten.bl.calender.DayEvent;
import il.co.grauman.kindergarten.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEventToCalendarActivity extends AppCompatActivity {

    private static final String TAG = "AddEventToCalendar";
    private TextView mDisplayDate;
    private TextView etTitle;
    private TextView etDescription;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private String datePicked;
    private Button btnCancel;
    private ImageButton btnSaveEvent;
    private int pickedYear;
    private int pickedMonth;
    private int pickedDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event_to_calendar);

        setupUIElements();

        mDisplayDate.setOnClickListener(v -> {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddEventToCalendarActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + (month+1) + "/" + day + "/" + year);

                datePicked = year + "/" + (month+1) + "/" + day;
                pickedYear = year;
                pickedMonth = month;
                pickedDay = day;
                mDisplayDate.setText(datePicked);
            }
        };

        btnCancel.setOnClickListener(v-> {
            Intent returnIntent = new Intent();
            setResult(Activity.RESULT_CANCELED, returnIntent);
            finish();
        });

        btnSaveEvent.setOnClickListener(v -> {

            if(etTitle.getText().toString().isEmpty()){
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
            }

            Calendar datePicked = Calendar.getInstance();
            datePicked.set(Calendar.YEAR, pickedYear);
            datePicked.set(Calendar.MONTH, pickedMonth);
            datePicked.set(Calendar.DAY_OF_MONTH, pickedDay);
            Date dateSent = new Date(datePicked.getTimeInMillis());
            Calender.getInstance().addEventToCalender(new DayEvent(dateSent, etTitle.getText().toString(), etDescription.getText().toString())
                    , new Callback<List<DayEvent>>() {
                @Override
                public void onResponse(Call<List<DayEvent>> call, Response<List<DayEvent>> response) {
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra(Constants.EVENT_ADDED_RESULT,etTitle.getText().toString());
                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();
                }

                @Override
                public void onFailure(Call<List<DayEvent>> call, Throwable t) {
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra(Constants.EVENT_ADDED_RESULT,"");
                    setResult(Constants.RESULT_FAILED,returnIntent);
                    finish();
                }
            });
        });
    }

    private void setupUIElements() {
        mDisplayDate = findViewById(R.id.tvDate);
        btnCancel = findViewById(R.id.btnCancelAddingEvent);
        btnSaveEvent = findViewById(R.id.ibSave);
        etTitle = findViewById(R.id.etNew_title);
        etDescription = findViewById(R.id.etNew_event);

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        //datePicked = currentYear + "/" + (currentMonth+1) + "/" + currentDay;
        mDisplayDate.setText(String.format(getString(R.string.date_format),
                String.valueOf(currentYear),
                String.valueOf(currentMonth+1),
                String.valueOf(currentDay)));
    }
}
