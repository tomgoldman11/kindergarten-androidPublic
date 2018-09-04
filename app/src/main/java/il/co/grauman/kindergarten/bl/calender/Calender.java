package il.co.grauman.kindergarten.bl.calender;

import java.util.List;

import il.co.grauman.kindergarten.bl.references.ApiImplementation;
import il.co.grauman.kindergarten.bl.references.RetrofitInstance;
import il.co.grauman.kindergarten.bl.references.StatusResponse;
import retrofit2.Callback;


public class Calender {
    
    public static void getEventsFromCalender(int year, Callback<List<DayEvent>> callback) {
        ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                .getApi().getCalender(year));
    }

    public static void updateEventToCalender(DayEvent newEvent, Callback<List<DayEvent>> callback) {
        ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                .getApi().updateCalender(newEvent));
    }

    public static void addEventToCalender(DayEvent newEvent, Callback<List<DayEvent>> callback) {
        ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                .getApi().addCalender(newEvent));
    }
}
