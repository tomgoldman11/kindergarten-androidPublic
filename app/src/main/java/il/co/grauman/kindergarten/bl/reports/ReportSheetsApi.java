package il.co.grauman.kindergarten.bl.reports;

import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.bl.references.StatusResponse;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Child;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DailySummary;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DayActivtyPart;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Report;
import il.co.grauman.kindergarten.bl.reports.reportsModles.WorkHours;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Worker;
import il.co.grauman.kindergarten.bl.reports.reportsRequests.DailySummaryRequest;
import il.co.grauman.kindergarten.models.Agenda;
import il.co.grauman.kindergarten.models.DailySummaryDTO;
import il.co.grauman.kindergarten.models.Kid;
import il.co.grauman.kindergarten.models.Shift;
import il.co.grauman.kindergarten.models.User;

public interface ReportSheetsApi {
    void getHoursReportForWorker(int month , int year , String userID , retrofit2.Callback<List<Shift>> callback);
    void getHoursReport(int month , int year , retrofit2.Callback<List<Shift>> callback);
    void addDailySchedule(Agenda agenda , retrofit2.Callback<Agenda> callback);
    void removeDailySchedule(Agenda agenda , retrofit2.Callback<Agenda> callback);
    void getDailySchedule(Date day , retrofit2.Callback<List<Agenda>> callback);
    void getDailySummary(Date day , retrofit2.Callback<DailySummaryDTO> callback);
    void addDailySummary(DailySummaryRequest dailySummaryRequest , retrofit2.Callback<DailySummaryDTO> callback);
    void getLateChildren(Date day , retrofit2.Callback<List<Kid>> callback);
    void reportsTo(Report report , retrofit2.Callback<Report> callback);
    void getReports(retrofit2.Callback<List<Report>> callback);
    void getWorkersList(retrofit2.Callback<List<User>>callback);
}
