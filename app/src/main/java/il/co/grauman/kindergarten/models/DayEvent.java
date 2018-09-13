package il.co.grauman.kindergarten.models;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import il.co.grauman.kindergarten.enums.EventType;

public class DayEvent {

    private int id;
    private Date date;
    private EventType type;
    private String description;
    private Time from;
    private Time to;


    public DayEvent(int id, Date date, EventType type, String description, Time from, Time to) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.description = description;
        this.from = from;
        this.to = to;
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
}
