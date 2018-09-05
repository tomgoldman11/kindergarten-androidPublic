package il.co.grauman.kindergarten.bl.calender;

import java.util.List;

public class UpdateCalenderRequest {
    List<DayEvent> newSchedule;

    public UpdateCalenderRequest(List<DayEvent> newSchedule) {
        this.newSchedule = newSchedule;
    }

    public List<DayEvent> getNewSchedule() {
        return newSchedule;
    }

    public void setNewSchedule(List<DayEvent> newSchedule) {
        this.newSchedule = newSchedule;
    }
}
