package il.co.grauman.kindergarten.bl.calender;

import java.util.Date;

public class Event {
    Date day;
    String event , description ;

    public Event(Date day, String event, String description) {
        this.day = day;
        this.description = description;
        this.event = event;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
