package il.co.grauman.kindergarten.bl.reports;

import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.bl.references.StatusResponse;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Child;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DailySum;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DaySchedule;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Report;
import il.co.grauman.kindergarten.bl.reports.reportsModles.WorkHours;

public interface ReportSheetsApi {
    void getHoursReportForWorker(int month , int year , String userID , retrofit2.Callback<List<WorkHours>> callback);
    void getHoursReport(int month , int year , retrofit2.Callback<List<WorkHours>> callback);
    void getDailySchedule(Date day , retrofit2.Callback<List<DaySchedule>> callback);
    void getDailySum(Date day , retrofit2.Callback<DailySum> callback);
    void getLateChildren(Date day , retrofit2.Callback<List<Child>> callback);
    void reportsTo(Report report , retrofit2.Callback<StatusResponse> callback);
    void getReports(retrofit2.Callback<List<Report>> callback);
}
