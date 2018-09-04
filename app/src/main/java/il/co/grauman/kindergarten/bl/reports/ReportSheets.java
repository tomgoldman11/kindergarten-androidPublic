package il.co.grauman.kindergarten.bl.reports;

import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.bl.references.ApiImplementation;
import il.co.grauman.kindergarten.bl.references.RetrofitInstance;
import il.co.grauman.kindergarten.bl.references.StatusResponse;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Child;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DailySummary;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DayActivty;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Report;
import il.co.grauman.kindergarten.bl.reports.reportsModles.WorkHours;
import il.co.grauman.kindergarten.bl.reports.reportsRequests.EmployeeReportsRequest;
import il.co.grauman.kindergarten.bl.reports.reportsRequests.ReportsRequest;
import retrofit2.Callback;

public class ReportSheets {
    private static ReportSheetsApi instance;

    public static ReportSheetsApi getInstace() {
        if(instance == null) {
            instance = new ReportSheetsApi() {

                @Override
                public void getHoursReportForWorker(int month, int year, String
                        userID, retrofit2.Callback<List<WorkHours>> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getHoursReportForWorker(new EmployeeReportsRequest(month, year, userID)));
                }

                @Override
                public void getHoursReport(int month, int year, Callback<List<WorkHours>> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getHoursReport(new ReportsRequest(month, year)));
                }

                @Override
                public void getDailySchedule(Date day, Callback<List<DayActivty>> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getDailySchedule(day));
                }

                @Override
                public void getDailySummary(Date day, Callback<DailySummary> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getDailySummary(day));
                }

                @Override
                public void getLateChildren(Date day, Callback<List<Child>> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getLateChildren(day));
                }

                @Override
                public void reportsTo(Report report, retrofit2.Callback<StatusResponse> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().reportsTo(report));
                }

                @Override
                public void getReports(retrofit2.Callback<List<Report>> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getReports());
                }
            };
        }
        return instance;
    }


}
