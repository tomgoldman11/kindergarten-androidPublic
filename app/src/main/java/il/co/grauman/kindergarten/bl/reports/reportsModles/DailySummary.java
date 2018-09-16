package il.co.grauman.kindergarten.bl.reports.reportsModles;

import java.util.Date;
import java.util.List;

public class DailySummary<T> {
    Date day;
    String event;
    T pictures;

    public DailySummary(Date day, String event, T pictures) {
        this.day = day;
        this.event = event;
        this.pictures = pictures;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public T getPictures() {
        return pictures;
    }

    public void setPictures(T pictures) {
        this.pictures = pictures;
    }
}