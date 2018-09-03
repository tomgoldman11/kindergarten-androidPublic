package il.co.grauman.kindergarten.bl.calender;

import java.util.List;

public class YearSchedule {
    List<DayEvent> yearSchedule;

    public YearSchedule(List<DayEvent> yearSchedule) {
        this.yearSchedule = yearSchedule;
    }

    public List<DayEvent> getYearSchedule() {
        return yearSchedule;
    }

    public void setYearSchedule(List<DayEvent> yearSchedule) {
        this.yearSchedule = yearSchedule;
    }
}
