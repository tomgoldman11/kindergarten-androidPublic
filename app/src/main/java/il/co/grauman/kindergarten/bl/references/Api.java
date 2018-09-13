package il.co.grauman.kindergarten.bl.references;

import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.bl.calender.DayEvent;
import il.co.grauman.kindergarten.bl.login.ChckInOutRequest;
import il.co.grauman.kindergarten.bl.login.LoginRequest;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Child;
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
import il.co.grauman.kindergarten.models.DailySummaryDTO;
import il.co.grauman.kindergarten.models.Kid;
import il.co.grauman.kindergarten.models.Shift;
import il.co.grauman.kindergarten.models.User;
import il.co.grauman.kindergarten.models.WorkerShiftsDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {
    public final String BASE_URL ="http://localhost/Authentication/webapi/";

    @POST ("auth/login")
    Call<User>userLogin(@Body LoginRequest req);

    @POST ("auth/me")
    Call<User>getLogedUserr();

    @POST ("auth/logout")
    Call<StatusResponse>getLogedout();


    @GET ("shifts/get-by-date-by-worker/{workerId}/from/{fromDate}")
    Call<WorkerShiftsDTO> getWorkSchedule(@Body AdminShiftsRequest shift);

    @GET("shifts/get-by-date/from/{fromDate}")
    Call<List<DailyShift>> getWorkSchedule(@Path("fromDate") String formDate);

    @POST("shifts/add")
    Call<Shift> addShift(@Body Shift dailyShift);

    @POST("shifts/delete")
    Call<Shift> removeShift(@Body Shift dailyShift);

    @POST("shifts/update")
    Call<Shift> updateShift(@Body Shift updateShiftRequset);

    @POST("admin/users/add")
    Call<User> addUser(@Body User user);


    @POST("shifts/checkin")
    Call<StatusResponse> checkIn(@Body ChckInOutRequest checkInRequest);

    @POST("shifts/checkout")
    Call<StatusResponse> checkOut(@Body ChckInOutRequest checkOutRequest);

    @POST("shifts/hours-report-worker")
    Call<List<Shift>> getHoursReportForWorker(@Body EmployeeReportsRequest request);

    @POST("shifts/hours-report-all")
    Call<List<Shift>> getHoursReport(@Body ReportsRequest request);


    @POST("agenda/getagenda")
    Call<List<Agenda>> getDailySchedule(@Body Date day);

    @POST("agenda/add-agenda-part")
    Call<Agenda> addDailySchedule(@Body Agenda agenda);


    @POST("agenda/remove-agenda-part")
    Call<Agenda> removeDailySchedule(@Body Agenda agenda);


    @GET("summary/get-daily-summary")
    Call<DailySummaryDTO> getDailySummary(@Body Date day);


    @POST("myresource/add_daily_summary")
    Call<DailySummaryDTO> addDailySummary(@Body DailySummaryRequest dailySummaryRequest);


    @GET("events/get{year}")
    Call<List<DayEvent>> getCalender(@Body int year);

    @POST("events/update")
    Call<DayEvent> updateCalender(@Body DayEvent newEvent);

    @POST("events/add")
    Call<DayEvent> addCalender(@Body DayEvent dayEvent);


    @POST("events/delete")
    Call<DayEvent> deleteCalender(@Body Integer dayEvent);

    @GET("admin/late")
    Call<List<Kid>> getLateKids(@Body Date day);

    @POST("reports/add")
    Call<Report> reportsTo(@Body Report report);

    @POST("reports/all")
    Call<List<Report>> getReports();

    @GET("admin/get-workers")
    Call<List<User>> getWorkersList();
}
