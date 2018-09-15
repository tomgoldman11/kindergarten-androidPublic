package il.co.grauman.kindergarten.bl.calender;

import java.util.List;

import il.co.grauman.kindergarten.bl.references.StatusResponse;

public interface CalenderApi {
    void getEventsFromCalender(int year , retrofit2.Callback<List<DayEvent>> callback);
    void updateEventToCalender(DayEvent newEvent, retrofit2.Callback<List<DayEvent>> callback);
    void deleteCalender(DayEvent newEvent, retrofit2.Callback<List<DayEvent>> callback);
    void addEventToCalender(DayEvent dayEvents, retrofit2.Callback<List<DayEvent>> callback);
    //should be called deleteEventFromCalender
    void deleteCalender(Integer dayEvent, retrofit2.Callback<DayEvent> callback);

}
