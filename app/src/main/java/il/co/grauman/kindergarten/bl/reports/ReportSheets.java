package il.co.grauman.kindergarten.bl.reports;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.bl.references.ApiImplementation;
import il.co.grauman.kindergarten.bl.references.RetrofitInstance;
import il.co.grauman.kindergarten.bl.references.StatusResponse;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Child;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DailySummary;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DailySummaryDTO;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DayActivtyPart;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Report;
import il.co.grauman.kindergarten.bl.reports.reportsModles.WorkHours;
import il.co.grauman.kindergarten.bl.reports.reportsModles.Worker;
import il.co.grauman.kindergarten.bl.reports.reportsRequests.DailySummaryRequest;
import il.co.grauman.kindergarten.bl.reports.reportsRequests.EmployeeReportsRequest;
import il.co.grauman.kindergarten.bl.reports.reportsRequests.ReportsRequest;
import il.co.grauman.kindergarten.models.Agenda;
import il.co.grauman.kindergarten.models.Kid;
import il.co.grauman.kindergarten.models.KidContact;
import il.co.grauman.kindergarten.models.User;
import retrofit2.Call;
import retrofit2.Callback;

public class ReportSheets {
    private static ReportSheetsApi instance;

    public static ReportSheetsApi getInstace() {
        if(instance == null) {
            instance = new ReportSheetsApi() {

                @Override
                public void getHoursReportForWorker(String userID,int month, int year, retrofit2.Callback<List<WorkHours>> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getHoursReportForWorker(userID, month, year));
                }

                @Override
                public void getHoursReport(int month, int year, Callback<List<WorkHours>> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getHoursReport(month, year));
                }

                @Override
                public void getDailySchedule(String day, Callback<List<Agenda>> callback) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String fromDateString = format.format(day);

                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getDailySchedule(day));
                }
                @Override
                public void addDailySchedule(Agenda agenda, Callback<Agenda> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().addDailySchedule(agenda));
                }

                @Override
                public void removeDailySchedule(Agenda agenda, Callback<Agenda> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().removeDailySchedule(agenda));
                }


                @Override
                public void getDailySummary(String day, Callback<DailySummaryDTO> callback) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String fromDateString = format.format(day);

                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getDailySummary(day));
                }

                @Override
                public void addDailySummary(DailySummaryRequest dailySummaryrequest, Callback<DailySummaryDTO> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().addDailySummary(dailySummaryrequest));
                }

                @Override
                public void getLateChildren(String day, Callback<List<Child>> callback) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String fromDateString = format.format(day);

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

                @Override
                public void getWorkersList(retrofit2.Callback<List<User>>callback){
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                    .getApi().getWorkersList());
                }

                @Override
                public void getKids(retrofit2.Callback<List<Kid>> callback){
                    ApiImplementation.apiImplementation(callback, ()-> RetrofitInstance.getInstance()
                    .getApi().getKids());
                }

                @Override
                public void setKidCheckIn(String kidID ,retrofit2.Callback<StatusResponse> callback){
                    ApiImplementation.apiImplementation(callback, ()-> RetrofitInstance.getInstance()
                    .getApi().setKidCheckIn(kidID));
                }

                @Override
                public void setKidCheckOut(String kidID ,retrofit2.Callback<StatusResponse> callback){
                    ApiImplementation.apiImplementation(callback, ()-> RetrofitInstance.getInstance()
                            .getApi().setKidCheckOut(kidID));
                }

                @Override
                public void getKidContact(String kidID,retrofit2.Callback<List<KidContact>> callback){
                    ApiImplementation.apiImplementation(callback, ()-> RetrofitInstance.getInstance()
                    .getApi().getKidContact(kidID));
                }


            };
        }
        return instance;
    }


}
