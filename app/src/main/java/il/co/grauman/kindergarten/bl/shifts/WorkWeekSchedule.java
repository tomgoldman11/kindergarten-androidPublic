package il.co.grauman.kindergarten.bl.shifts;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.bl.references.ApiImplementation;
import il.co.grauman.kindergarten.bl.references.RetrofitInstance;
import il.co.grauman.kindergarten.bl.shifts.shiftModels.DailyShift;
import il.co.grauman.kindergarten.bl.shifts.shiftRequests.EmployeeShiftsRequest;
import retrofit2.Callback;

public class WorkWeekSchedule {


    private static WorkScheduleApi instance;

    public static WorkScheduleApi getInstance() {
        if (instance == null) {
            instance = new WorkScheduleApi() {

                @Override
                public void getWorkSchedule(String userId, Date day, Callback<List<DailyShift>> callback) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(day);
                    while (calendar.get(Calendar.DAY_OF_WEEK) > calendar.getFirstDayOfWeek()) {
                        calendar.add(Calendar.DATE, -1); // Substract 1 day until first day of week.
                    }
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String fromDateString = format.format(day);

                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getWorkSchedule(new EmployeeShiftsRequest(fromDateString, userId)));
                }

                @Override
                public void getWorkSchedule(Date day, Callback<List<DailyShift>> callback) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(day);
                    while (calendar.get(Calendar.DAY_OF_WEEK) > calendar.getFirstDayOfWeek()) {
                        calendar.add(Calendar.DATE, -1); // Substract 1 day until first day of week.
                    }
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String fromDateString = format.format(day);
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getWorkSchedule(fromDateString));
                }
            };
        }
        return  instance;
    }
}
