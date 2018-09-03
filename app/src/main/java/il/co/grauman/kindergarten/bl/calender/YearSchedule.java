package il.co.grauman.kindergarten.bl.calender;

import java.util.List;

public class YearSchedule {
    List<Event> yearSchedule;

    public YearSchedule(List<Event> yearSchedule) {
        this.yearSchedule = yearSchedule;
    }

    public List<Event> getYearSchedule() {
        return yearSchedule;
    }

    public void setYearSchedule(List<Event> yearSchedule) {
        this.yearSchedule = yearSchedule;
    }
}
