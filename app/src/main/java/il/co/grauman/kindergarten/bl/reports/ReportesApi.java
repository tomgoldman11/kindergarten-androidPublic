package il.co.grauman.kindergarten.bl.reports;

import java.util.Date;
import java.util.List;

import javax.security.auth.callback.Callback;

public interface ReportesApi {
    void getHoursReportForWorker(int month , int year , String userID , retrofit2.Callback<List<WorkHours>> callback);
    void getHoursReport(int month , int year , retrofit2.Callback<List<WorkHours>> callback);
    void getDailySchedule(Date day , retrofit2.Callback<List<DaySchedule>> callback);
    void getDailySum(Date day , retrofit2.Callback<DailySum> callback);
}
