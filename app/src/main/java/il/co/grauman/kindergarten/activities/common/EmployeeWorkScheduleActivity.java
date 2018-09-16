package il.co.grauman.kindergarten.activities.common;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.bl.reports.reportsModles.WorkHours;
import il.co.grauman.kindergarten.bl.shifts.shiftModels.DailyShift;
import il.co.grauman.kindergarten.enums.Role;
import il.co.grauman.kindergarten.utils.Constants;
import il.co.grauman.kindergarten.utils.SPref;

public class EmployeeWorkScheduleActivity extends BaseDrawerActivity {
    java.util.Calendar calendar;
    String currentEmployee;
    Date currentDate;
    SimpleDateFormat dateFormat;

    Spinner spinner;

    TextView dateStart;
    TextView dateEnds;
    TextView SundayDate;
    TextView MondayDate;
    TextView TuesdayDate;
    TextView WednesdayDate;
    TextView ThursdayDate;
    TextView FridayDate;

    ImageButton addBtnSunday;
    ImageButton addBtnMonday;
    ImageButton addBtnTuesday;
    ImageButton addBtnWednesday;
    ImageButton addBtnThursday;
    ImageButton addBtnFriday;

    ImageButton deleteBtnSunday;
    ImageButton deleteBtnMonday;
    ImageButton deleteBtnTuesday;
    ImageButton deleteBtnWednesday;
    ImageButton deleteBtnThursday;
    ImageButton deleteBtnFriday;

    DailyShift shifts;

    TextView tvHourSunday;
    TextView tvHourMonday;
    TextView tvHourTuesday;
    TextView tvHourWednesday;
    TextView tvHourThursday;
    TextView tvHourFriday;

    List<WorkHours> currentShift = new ArrayList<WorkHours>();

    Date sundayDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_arrangement);

//        setUIElements();
//
//        setDates();
//
//        setButtons();
//
//        setEmployeeNamesInSpinner();
//
//        setEventsListeners();

    }
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                                              @Override
//                                              public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
//                                                  RetrofitInstance.getInstance().getApi().getHoursReportForWorker(currentDate.getMonth(), currentDate.getYear(), currentEmployee, new Callback<List<WorkHours>>() {
//
//                                                      @Override
//                                                      public void onResponse(Call<List<WorkHours>> call, Response<List<WorkHours>> response) {
//
//                                                      }
//
//                                                      @Override
//                                                      public void onFailure(Call<List<WorkHours>> call, Throwable t) {
//
//                                                      }
//                                                  });
//
//                                                  @Override
//                                                  public void onNothingSelected (AdapterView < ? > parentView){
//                                                      // your code here
//                                                  }
//                                              }
//
//                                              ;
//                                          }
//
////        addBtnSunday.setOnClickListener(v -> {
////            checkBox1.setImageResource(android.R.drawable.checkbox_on_background);
////            RetrofitInstance.getInstance().getApi().addShift(new DailyShift(currentEmployee, ))
////        });
////        addBtnMonday.setOnClickListener(v -> {
////            checkBox2.setImageResource(android.R.drawable.checkbox_on_background);
////        });
////        addBtnTuesday.setOnClickListener(v -> {
////            checkBox3.setImageResource(android.R.drawable.checkbox_on_background);
////        });
////        addBtnWednesday.setOnClickListener(v -> {
////            checkBox4.setImageResource(android.R.drawable.checkbox_on_background);
////        });
////        addBtnThursday.setOnClickListener(v -> {
////            checkBox5.setImageResource(android.R.drawable.checkbox_on_background);
////        });
////        addBtnFriday.setOnClickListener(v -> {
////            checkBox6.setImageResource(android.R.drawable.checkbox_on_background);
////        });
////
////        deleteBtnSunday.setOnClickListener(v -> {
////            checkBox1.setImageResource(android.R.drawable.checkbox_off_background);
////        });
////        deleteBtnMonday.setOnClickListener(v -> {
////            checkBox2.setImageResource(android.R.drawable.checkbox_off_background);
////        });
////        deleteBtnTuesday.setOnClickListener(v -> {
////            checkBox3.setImageResource(android.R.drawable.checkbox_off_background);
////        });
////        deleteBtnWednesday.setOnClickListener(v -> {
////            checkBox4.setImageResource(android.R.drawable.checkbox_off_background);
////        });
////        deleteBtnThursday.setOnClickListener(v -> {
////            checkBox5.setImageResource(android.R.drawable.checkbox_off_background);
////        });
////        deleteBtnFriday.setOnClickListener(v -> {
////            checkBox6.setImageResource(android.R.drawable.checkbox_off_background);
////        });
//
//    }
////    private void setEmployeeNamesInSpinner(){
////        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
////        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
////        spinner.setAdapter(spinnerAdapter);
////
////
////        // BL TO GET WORKERS
////        RetrofitInstance.getInstance().getApi().getWorkers(new Callback<List<String>>() {
////            @Override
////            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
////                List<String> workers = response.body();
////                for (String worker: workers) {
////                    spinnerAdapter.add(worker.getWorkerName());
////                }
////                spinnerAdapter.notifyDataSetChanged();
////            }
////
////            @Override
////            public void onFailure(Call<List<String>> call, Throwable t) {
////
////            }
////        });
////
////
////    }

        private void setUIElements () {
            TextView tvHourSunday = findViewById(R.id.tvHourSunday);
            TextView tvHourMonday = findViewById(R.id.tvHourMonday);
            TextView tvHourTuesday = findViewById(R.id.tvHourTuesday);
            TextView tvHourWednesday = findViewById(R.id.tvHourWednesday);
            TextView tvHourThursday = findViewById(R.id.tvHourThursday);
            TextView tvHourFriday = findViewById(R.id.tvHourFriday);

            dateStart = findViewById(R.id.dateStart);
            dateEnds = findViewById(R.id.dateEnd);
            SundayDate = findViewById(R.id.tvDateSunday);
            MondayDate = findViewById(R.id.tvDateMonday);
            TuesdayDate = findViewById(R.id.tvDateTuesday);
            WednesdayDate = findViewById(R.id.tvDateWednesday);
            ThursdayDate = findViewById(R.id.tvDateThursday);
            FridayDate = findViewById(R.id.tvDateFriday);

            addBtnSunday = findViewById(R.id.btnNewWorkSunday);
            addBtnMonday = findViewById(R.id.btnNewWorkModay);
            addBtnTuesday = findViewById(R.id.btnNewWorkTuesday);
            addBtnWednesday = findViewById(R.id.btnNewWorkWednesday);
            addBtnThursday = findViewById(R.id.btnNewWorkThursday);
            addBtnFriday = findViewById(R.id.btnNewWorkFriday);

            deleteBtnSunday = findViewById(R.id.btnDeleteWorkSunday);
            deleteBtnMonday = findViewById(R.id.btnDeleteWorkMonday);
            deleteBtnTuesday = findViewById(R.id.btnDeleteWorkTuesday);
            deleteBtnWednesday = findViewById(R.id.btnDeleteWorkWednesday);
            deleteBtnThursday = findViewById(R.id.btnDeleteWorkThursday);
            deleteBtnFriday = findViewById(R.id.btnDeleteWorkFriday);

            spinner = findViewById(R.id.spinnerChooseWorker);
            //    setEmployeeNamesInSpinner();
        }

        private void setDates () {
            calendar = java.util.Calendar.getInstance();
            dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            currentDate = calendar.getTime();
            calendar.add(Calendar.DAY_OF_WEEK, -(calendar.get(Calendar.DAY_OF_WEEK) - 1));
            sundayDate = calendar.getTime();

            String formattedDate = dateFormat.format(currentDate);
            dateStart.setText(formattedDate);

            List<TextView> datesArr = new ArrayList<TextView>();
            datesArr.add(SundayDate);
            datesArr.add(MondayDate);
            datesArr.add(TuesdayDate);
            datesArr.add(WednesdayDate);
            datesArr.add(ThursdayDate);
            datesArr.add(FridayDate);
            datesArr.add(dateEnds);


            for (int i = 0; i < 7; i++) {
                currentDate = calendar.getTime();
                calendar.add(java.util.Calendar.DAY_OF_YEAR, 1);
                formattedDate = dateFormat.format(currentDate);
                datesArr.get(i).setText(formattedDate);
            }


        }

        private void setButtons () {
            if (Role.values()[SPref.getInstance().getInt(Constants.ROLE, 3)] != Role.ADMIN) {
                addBtnSunday.setVisibility(View.GONE);
                addBtnMonday.setVisibility(View.GONE);
                addBtnTuesday.setVisibility(View.GONE);
                addBtnWednesday.setVisibility(View.GONE);
                addBtnThursday.setVisibility(View.GONE);
                addBtnFriday.setVisibility(View.GONE);

                deleteBtnSunday.setVisibility(View.GONE);
                deleteBtnMonday.setVisibility(View.GONE);
                deleteBtnTuesday.setVisibility(View.GONE);
                deleteBtnWednesday.setVisibility(View.GONE);
                deleteBtnThursday.setVisibility(View.GONE);
                deleteBtnFriday.setVisibility(View.GONE);

            }
        }
    }
