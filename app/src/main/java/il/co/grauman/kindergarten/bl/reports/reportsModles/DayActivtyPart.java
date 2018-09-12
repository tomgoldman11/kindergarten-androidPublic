package il.co.grauman.kindergarten.bl.reports.reportsModles;

import java.sql.Time;
import java.util.Date;

public class DayActivtyPart {
    Date day;
    Time fromHr;
    Time toHr;
    String discreption;

    public DayActivtyPart(Date day, Time fromHr, Time toHr, String discreption) {
        this.day = day;
        this.fromHr = fromHr;
        this.toHr = toHr;
        this.discreption = discreption;
    }

    public Time getFromHr() {
        return fromHr;
    }

    public void setFromHr(Time fromHr) {
        this.fromHr = fromHr;
    }

    public Time getToHr() {
        return toHr;
    }

    public void setToHr(Time toHr) {
        this.toHr = toHr;
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
