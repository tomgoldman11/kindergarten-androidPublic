package il.co.grauman.kindergarten.bl.shifts;

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
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getWorkSchedule(new EmployeeShiftsRequest(day, userId)));
                }

                @Override
                public void getWorkSchedule(Date day, Callback<List<DailyShift>> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getWorkSchedule(day));
                }
            };
        }
        return  instance;
    }
}
