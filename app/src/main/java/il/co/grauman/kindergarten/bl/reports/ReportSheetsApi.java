package il.co.grauman.kindergarten.bl.reports;

import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.bl.references.StatusResponse;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Child;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DailySummary;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DailySummaryDTO;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DayActivtyPart;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Report;
import il.co.grauman.kindergarten.bl.reports.reportsModles.WorkHours;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Worker;
import il.co.grauman.kindergarten.bl.reports.reportsRequests.DailySummaryRequest;
import il.co.grauman.kindergarten.models.Agenda;
import il.co.grauman.kindergarten.models.User;

public interface ReportSheetsApi {
    void getHoursReportForWorker(String userID ,int month , int year , retrofit2.Callback<List<WorkHours>> callback);
    void getHoursReport(int month , int year , retrofit2.Callback<List<WorkHours>> callback);
    void getDailySchedule(String day , retrofit2.Callback<List<Agenda>> callback);
    void addDailySchedule(Agenda agenda , retrofit2.Callback<Agenda> callback);
    void removeDailySchedule(Agenda agenda , retrofit2.Callback<Agenda> callback);
    void getDailySummary(String day , retrofit2.Callback<DailySummaryDTO> callback);
    void addDailySummary(DailySummaryRequest dailySummaryRequest , retrofit2.Callback<DailySummaryDTO> callback);
    void getLateChildren(String day , retrofit2.Callback<List<Child>> callback);
    void reportsTo(Report report , retrofit2.Callback<StatusResponse> callback);
    void getReports(retrofit2.Callback<List<Report>> callback);
    void getWorkersList(retrofit2.Callback<List<User>>callback);
}
