package il.co.grauman.kindergarten.bl.reports;

import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.bl.references.ApiImplementation;
import il.co.grauman.kindergarten.bl.references.RetrofitInstance;
import il.co.grauman.kindergarten.bl.references.StatusResponse;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Child;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DailySummary;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DayActivtyPart;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Report;
import il.co.grauman.kindergarten.bl.reports.reportsModles.WorkHours;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Worker;
import il.co.grauman.kindergarten.bl.reports.reportsRequests.DailySummaryRequest;
import il.co.grauman.kindergarten.bl.reports.reportsRequests.EmployeeReportsRequest;
import il.co.grauman.kindergarten.bl.reports.reportsRequests.ReportsRequest;
import il.co.grauman.kindergarten.models.Agenda;
import il.co.grauman.kindergarten.models.DailySummaryDTO;
import il.co.grauman.kindergarten.models.Kid;
import il.co.grauman.kindergarten.models.Shift;
import il.co.grauman.kindergarten.models.User;
import retrofit2.Callback;

public class ReportSheets {
    private static ReportSheetsApi instance;

    public static ReportSheetsApi getInstace() {
        if(instance == null) {
            instance = new ReportSheetsApi() {

                @Override
                public void getHoursReportForWorker(int month, int year, String
                        userID, retrofit2.Callback<List<Shift>> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getHoursReportForWorker(new EmployeeReportsRequest(month, year, userID)));
                }

                @Override
                public void getHoursReport(int month, int year, Callback<List<Shift>> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getHoursReport(new ReportsRequest(month, year)));
                }

                @Override
                public void addDailySchedule(Agenda agenda, Callback<Agenda> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().addDailySchedule(agenda));
                }

                @Override
                public void removeDailySchedule(Agenda agenda, Callback<Agenda> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().addDailySchedule(agenda));
                }

                @Override
                public void getDailySchedule(Date day, Callback<List<Agenda>> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getDailySchedule(day));
                }

                @Override
                public void getDailySummary(Date day, Callback<DailySummaryDTO> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getDailySummary(day));
                }

                @Override
                public void addDailySummary(DailySummaryRequest dailySummaryrequest, Callback<DailySummaryDTO> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().addDailySummary(dailySummaryrequest));
                }

                @Override
                public void getLateChildren(Date day, Callback<List<Kid>> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getLateKids(day));
                }

                @Override
                public void reportsTo(Report report, retrofit2.Callback<Report> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().reportsTo(report));
                }

                @Override
                public void getReports(retrofit2.Callback<List<Report>> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getReports());
                }

                @Override
                public void getWorkersList(retrofit2.Callback<List<User>>callback){
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                    .getApi().getWorkersList());
                }

            };
        }
        return instance;
    }


}
