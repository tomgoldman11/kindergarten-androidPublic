package il.co.grauman.kindergarten.bl.reports.reportsModles;

import java.util.Date;
import java.util.List;

public class DailySummary {
    Date day;
    String event;
    List<String> pictures;

    public DailySummary(Date day, String event, List<String> pictures) {
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

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }
}
