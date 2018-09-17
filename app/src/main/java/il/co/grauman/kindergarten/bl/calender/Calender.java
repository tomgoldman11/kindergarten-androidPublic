package il.co.grauman.kindergarten.bl.calender;

import java.util.List;

import il.co.grauman.kindergarten.bl.references.ApiImplementation;
import il.co.grauman.kindergarten.bl.references.RetrofitInstance;
import retrofit2.Callback;


public class Calender {

    private static CalenderApi instance;

    public static CalenderApi getInstance() {
        if (instance == null) {
            instance = new CalenderApi() {

                @Override
                public void getEventsFromCalender(int year, Callback<List<DayEvent>> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().getCalender(year));
                }

                @Override
                public void updateEventToCalender(DayEvent newEvent, Callback<DayEvent> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().updateCalender(newEvent));
                }

                @Override
                public void addEventToCalender(DayEvent newEvent, Callback<DayEvent> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().addCalender(newEvent));
                }

                @Override
                public void deleteEventToCalender(DayEvent event, Callback<DayEvent> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().deleteCalender(event));
                }
            };
        }

        return instance;
    }
}
