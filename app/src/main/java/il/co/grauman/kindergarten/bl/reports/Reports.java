package il.co.grauman.kindergarten.bl.reports;

import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.bl.references.ApiImplementation;
import il.co.grauman.kindergarten.bl.references.RetrofitInstance;
import retrofit2.Callback;

public class Reports implements ReportesApi {
    @Override
    public void getHoursReportForWorker(int month , int year, String userID , retrofit2.Callback<List<WorkHours>> callback){
        ApiImplementation.apiImplementation(callback , ()-> RetrofitInstance.getInstance()
        .getApi().getHoursReportForWorker(new EmployeeReportsRequest(month , year , userID)));
    }

    @Override
    public void getHoursReport(int month, int year, Callback<List<WorkHours>> callback) {
        ApiImplementation.apiImplementation(callback , ()-> RetrofitInstance.getInstance()
        .getApi().getHoursReport(new ReportsRequest(month, year)));
    }

    @Override
    public void getDailySchedule(Date day, Callback<List<DaySchedule>> callback) {

    }

    @Override
    public void getDailySum(Date day, Callback<DailySum> callback) {

    }

}
