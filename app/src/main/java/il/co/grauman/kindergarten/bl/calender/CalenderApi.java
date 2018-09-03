package il.co.grauman.kindergarten.bl.calender;

import il.co.grauman.kindergarten.bl.references.StatusResponse;

public interface CalenderApi {
    void getCalender(int year , retrofit2.Callback<YearSchedule> callback);
    void updateCalender(YearSchedule newSchedule , YearSchedule oldSchedule , retrofit2.Callback<StatusResponse> callback);
}
