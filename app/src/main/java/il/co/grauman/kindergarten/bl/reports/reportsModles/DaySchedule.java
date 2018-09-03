package il.co.grauman.kindergarten.bl.reports.reportsModles;

import java.util.Date;

public class DaySchedule {
    Date day;
    String discreption;

    public DaySchedule(Date day, String discreption) {
        this.day = day;
        this.discreption = discreption;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getDiscreption() {
        return discreption;
    }

    public void setDiscreption(String discreption) {
        this.discreption = discreption;
    }
}
