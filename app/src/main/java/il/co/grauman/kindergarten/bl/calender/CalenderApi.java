package il.co.grauman.kindergarten.bl.calender;

import java.util.List;

import il.co.grauman.kindergarten.bl.references.StatusResponse;

public interface CalenderApi {
    void getCalender(List<DayEvent> year , retrofit2.Callback<List<DayEvent>> callback);
    void updateCalender(List<DayEvent> newSchedule , retrofit2.Callback<List<DayEvent>> callback);
}
