package il.co.grauman.kindergarten.bl.calender;

import java.util.List;

import il.co.grauman.kindergarten.bl.references.ApiImplementation;
import il.co.grauman.kindergarten.bl.references.RetrofitInstance;
import il.co.grauman.kindergarten.bl.references.StatusResponse;
import retrofit2.Callback;

public class Calender implements CalenderApi{
    @Override
    public void getCalender(int year, Callback<List<DayEvent>> callback) {
        ApiImplementation.apiImplementation(callback , ()-> RetrofitInstance.getInstance()
        .getApi().getCalender(year));
    }

    @Override
    public void updateEvent(DayEvent newEvent, Callback<List<DayEvent>> callback) {
        ApiImplementation.apiImplementation(callback , ()-> RetrofitInstance.getInstance()
        .getApi().updateCalender(newEvent));
    }

    @Override
    public void addEventToCalender(DayEvent dayEvent, Callback<List<DayEvent>> callback) {
        ApiImplementation.apiImplementation(callback , ()-> RetrofitInstance.getInstance()
        .getApi().addCalender(dayEvent));
    }
}
