package il.co.grauman.kindergarten.bl.calender;

import il.co.grauman.kindergarten.bl.references.ApiImplementation;
import il.co.grauman.kindergarten.bl.references.RetrofitInstance;
import il.co.grauman.kindergarten.bl.references.StatusResponse;
import retrofit2.Callback;

public class Calender implements CalenderApi{
    @Override
    public void getCalender(int year, Callback<YearSchedule> callback) {
        ApiImplementation.apiImplementation(callback , ()-> RetrofitInstance.getInstance()
        .getApi().getCalender(year));
    }

    @Override
    public void updateCalender(YearSchedule newSchedule, YearSchedule oldSchedule, Callback<StatusResponse> callback) {
        ApiImplementation.apiImplementation(callback , ()-> RetrofitInstance.getInstance()
        .getApi().updateCalender(new UpdateCalenderRequest(oldSchedule, newSchedule)));
    }
}
