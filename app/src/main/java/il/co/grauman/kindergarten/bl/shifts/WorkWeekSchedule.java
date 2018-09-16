package il.co.grauman.kindergarten.bl.shifts;

<<<<<<< HEAD
=======
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.bl.references.ApiImplementation;
import il.co.grauman.kindergarten.bl.references.RetrofitInstance;
import il.co.grauman.kindergarten.bl.shifts.shiftModels.DailyShift;
import il.co.grauman.kindergarten.bl.shifts.shiftRequests.EmployeeShiftsRequest;
import retrofit2.Callback;

>>>>>>> 9feaf18d6ae086072c87b3dcd114aec1d8205958
public class WorkWeekSchedule {


    private static WorkScheduleApi instance;

    public static WorkScheduleApi getInstance() {
<<<<<<< HEAD
//        if (instance == null) {
//            instance = new WorkScheduleApi() {
//
//                @Override
//                public void getWorkSchedule(String userId, Date day, Callback<List<DailyShift>> callback) {
//                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
//                            .getApi().getWorkSchedule(new EmployeeShiftsRequest(day, userId)));
//                }
//
//                @Override
//                public void getWorkSchedule(Date day, Callback<List<DailyShift>> callback) {
//                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
//                            .getApi().getWorkSchedule("011",day,callback);
//                }
//            };
//        }
//        return  instance;
        return instance;
=======
        if (instance == null) {
            instance = new WorkScheduleApi() {

                @Override
                public void getWorkSchedule(String userId, Date day, Callback<List<DailyShift>> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getWorkSchedule(new EmployeeShiftsRequest(day, userId)));
                }

                @Override
                public void getWorkSchedule(Date day, Callback<List<DailyShift>> callback) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(day);
                    while (calendar.get(Calendar.DAY_OF_WEEK) > calendar.getFirstDayOfWeek()) {
                        calendar.add(Calendar.DATE, -1); // Substract 1 day until first day of week.
                    }
                    Date from = calendar.getTime();
                    calendar.add(Calendar.DATE, 7);
                    Date to = calendar.getTime();
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String fromDateString = format.format(day);
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getWorkSchedule(fromDateString));
                }
            };
        }
        return  instance;
>>>>>>> 9feaf18d6ae086072c87b3dcd114aec1d8205958
    }
}
