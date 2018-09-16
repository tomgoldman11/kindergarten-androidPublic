package il.co.grauman.kindergarten.bl.references;

import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.BuildConfig;
import il.co.grauman.kindergarten.bl.calender.DayEvent;
import il.co.grauman.kindergarten.bl.login.ChckInOutRequest;
import il.co.grauman.kindergarten.bl.login.LoginRequest;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Child;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DailySummaryDTO;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Report;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DailySummary;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DayActivtyPart;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Worker;
import il.co.grauman.kindergarten.bl.reports.reportsRequests.DailySummaryRequest;
import il.co.grauman.kindergarten.bl.reports.reportsRequests.EmployeeReportsRequest;
import il.co.grauman.kindergarten.bl.reports.reportsRequests.ReportsRequest;
import il.co.grauman.kindergarten.bl.reports.reportsModles.WorkHours;
import il.co.grauman.kindergarten.bl.shifts.shiftRequests.AdminShiftsRequest;
import il.co.grauman.kindergarten.bl.shifts.shiftModels.DailyShift;
import il.co.grauman.kindergarten.bl.shifts.shiftRequests.UpdateShiftRequset;
import il.co.grauman.kindergarten.models.Agenda;
import il.co.grauman.kindergarten.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {
    String BASE_URL = BuildConfig.DEBUG ? "http://192.168.43.217:8080/kindergarten-rest/webapi/" : "http://3.120.93.72/kindergarten/webapi/";

    @POST("auth/login")
    Call<User> userLogin(@Body LoginRequest req);

    @POST("shifts/get-by-date-by-worker/from")
    Call<List<DailyShift>> getWorkSchedule(@Body AdminShiftsRequest shift);

    @GET("shifts/get-by-date/from/{fromDate}/to/{toDate}")
    Call<List<DailyShift>> getWorkSchedule(String formDate);

    @POST("shifts/add")
    Call<DailyShift> addShift(@Body DailyShift dailyShift);

    @POST("shifts/delete")
    Call<StatusResponse> removeShift(@Body DailyShift dailyShift);

    @POST("shifts/update")
    Call<StatusResponse> updateShift(@Body UpdateShiftRequset updateShiftRequset);

    @POST("admin/users/add")
    Call<User> addUser(@Body User user);

    @POST("shifts/checkin")
    Call<StatusResponse> checkIn(@Body ChckInOutRequest checkInRequest);

    @POST("shifts/checkout")
    Call<StatusResponse> checkOut(@Body ChckInOutRequest checkOutRequest);

    @POST("shifts/hours-report-worker")
    Call<List<WorkHours>> getHoursReportForWorker(@Body EmployeeReportsRequest request);

    @POST("shifts/hours-report-all")
    Call<List<WorkHours>> getHoursReport(@Body ReportsRequest request);

    @POST("agenda/get-agenda")
    Call<List<Agenda>> getDailySchedule(@Body Date day);

    @POST("summary/get-daily-summary")
    Call<DailySummaryDTO> getDailySummary(@Body Date day);

    @POST("summary/add-daily-summary")
    Call<DailySummaryDTO> addDailySummary(@Body DailySummaryRequest dailySummary);

    @GET("events/get/{year}")
    Call<List<DayEvent>> getCalender(@Path("year") int year);

    @POST("events/update")
    Call<DayEvent> updateCalender(@Body DayEvent newEvent);

    @POST("events/add")
    Call<DayEvent> addCalender(@Body DayEvent dayEvent);

    @POST("admin/")
    Call<List<Child>> getLateChildren(@Body Date day);

    @POST("myresource/reports_to")
    Call<StatusResponse> reportsTo(@Body Report report);

    @POST("myresource/get_reports")
    Call<List<Report>> getReports();

    @POST("myresource/get_workers_list")
    Call<List<User>> getWorkersList();
}
