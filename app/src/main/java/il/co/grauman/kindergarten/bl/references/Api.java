package il.co.grauman.kindergarten.bl.references;

import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.bl.calender.DayEvent;
import il.co.grauman.kindergarten.bl.login.ChckInOutRequest;
import il.co.grauman.kindergarten.bl.login.LoginRequest;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Child;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Report;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DailySummary;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DayActivty;
import il.co.grauman.kindergarten.bl.reports.reportsRequests.EmployeeReportsRequest;
import il.co.grauman.kindergarten.bl.reports.reportsRequests.ReportsRequest;
import il.co.grauman.kindergarten.bl.reports.reportsModles.WorkHours;
import il.co.grauman.kindergarten.bl.shifts.shiftRequests.AdminShiftsRequest;
import il.co.grauman.kindergarten.bl.shifts.shiftModels.DailyShift;
import il.co.grauman.kindergarten.bl.shifts.shiftRequests.UpdateShiftRequset;
import il.co.grauman.kindergarten.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {
    public final String BASE_URL ="http://10.0.2.2:9080/Authentication/webapi/";

    @POST ("myresource/login")
    Call<User>userLogin(@Body LoginRequest req);

    @POST ("myresource/scheduale")
    Call<List<DailyShift>> getWorkSchedule(@Body AdminShiftsRequest shift);

    @POST("myresource/admin_scheduale")
    Call<List<DailyShift>> getWorkSchedule(@Body Date day);

    @POST("myresource/add_shift")
    Call<DailyShift> addShift(@Body DailyShift dailyShift);

    @POST("myresource/remove_shift")
    Call<StatusResponse> removeShift(@Body DailyShift dailyShift);

    @POST("myresource/update_shift")
    Call<StatusResponse> updateShift(@Body UpdateShiftRequset updateShiftRequset);

    @POST("myresource/add_user")
    Call<User> addUser(@Body User user);

    @POST("myresource/checkin")
    Call<StatusResponse> checkIn(@Body ChckInOutRequest checkInRequest);

    @POST("myresource/checkout")
    Call<StatusResponse> checkOut(@Body ChckInOutRequest checkOutRequest);

    @POST("myresource/worker_hours_report")
    Call<List<WorkHours>> getHoursReportForWorker(@Body EmployeeReportsRequest request);

    @POST("myresource/get_hours_report")
    Call<List<WorkHours>> getHoursReport(@Body ReportsRequest request);

    @POST("myresource/get_daily_schedule")
    Call<List<DayActivty>> getDailySchedule(@Body Date day);

    @POST("myresource/get_daily_summary")
    Call<DailySummary> getDailySummary(@Body Date day);

    @POST("myresource/add_daily_summary")
    Call<DailySummary> addDailySummary(@Body DailySummary dailySummary);

    @POST("myresource/get_calender")
    Call<List<DayEvent>> getCalender(@Body int year);

    @POST("myresource/update_calender")
    Call<List<DayEvent>> updateCalender(@Body DayEvent newEvent);

    @POST("myresource/add_calender")
    Call<List<DayEvent>> addCalender(@Body DayEvent dayEvent);

    @POST("myresource/get_late_children")
    Call<List<Child>> getLateChildren(@Body Date day);

    @POST("myresource/reports_to")
    Call<StatusResponse> reportsTo(@Body Report report);

    @POST("myresource/get_reports")
    Call<List<Report>> getReports();


}
