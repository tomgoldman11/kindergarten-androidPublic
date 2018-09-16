package il.co.grauman.kindergarten.bl.calender;

import java.sql.Time;
import java.util.Date;

public class DayEvent {
    private Integer id;
    private String title;
    private String description;
    private Date date;
    private EventType type;
    private Time from;
    private Time to;

    public DayEvent(Integer id, String title, String description, Date date, EventType type, Time from, Time to) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.type = type;
        this.from = from;
        this.to = to;
    }

    public DayEvent(String title, String description, Date date, EventType type, Time from, Time to) {
        this(null, title, description, date, type, from, to);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getFrom() {
        return from;
    }

    public void setFrom(Time from) {
        this.from = from;
    }

    public Time getTo() {
        return to;
    }

    public void setTo(Time to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
