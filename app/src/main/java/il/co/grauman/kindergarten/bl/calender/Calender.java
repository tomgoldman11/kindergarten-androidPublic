package il.co.grauman.kindergarten.bl.calender;

import java.util.List;

import il.co.grauman.kindergarten.bl.references.ApiImplementation;
import il.co.grauman.kindergarten.bl.references.RetrofitInstance;
import il.co.grauman.kindergarten.bl.references.StatusResponse;
import retrofit2.Callback;

public class Calender implements CalenderApi{
    @Override
    public void getCalender(List<DayEvent> year, Callback<List<DayEvent>> callback) {
        ApiImplementation.apiImplementation(callback , ()-> RetrofitInstance.getInstance()
        .getApi().getCalender(year));
    }

    @Override
    public void updateCalender(List<DayEvent> newSchedule, Callback<List<DayEvent>> callback) {
        ApiImplementation.apiImplementation(callback , ()-> RetrofitInstance.getInstance()
        .getApi().updateCalender(newSchedule));
    }

    @Override
    public void addCalender(List<DayEvent> year, Callback<List<DayEvent>> callback) {
        ApiImplementation.apiImplementation(callback , ()-> RetrofitInstance.getInstance()
        .getApi().addCalender(year));
    }
}
