package il.co.grauman.kindergarten.bl.reports;

import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.bl.references.StatusResponse;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Child;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DailySummary;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DayActivty;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Report;
import il.co.grauman.kindergarten.bl.reports.reportsModles.WorkHours;

public interface ReportSheetsApi {
    void getHoursReportForWorker(int month , int year , String userID , retrofit2.Callback<List<WorkHours>> callback);
    void getHoursReport(int month , int year , retrofit2.Callback<List<WorkHours>> callback);
    void getDailySchedule(Date day , retrofit2.Callback<List<DayActivty>> callback);
    void getDailySummary(Date day , retrofit2.Callback<DailySummary> callback);
    void getLateChildren(Date day , retrofit2.Callback<List<Child>> callback);
    void reportsTo(Report report , retrofit2.Callback<StatusResponse> callback);
    void getReports(retrofit2.Callback<List<Report>> callback);
}
