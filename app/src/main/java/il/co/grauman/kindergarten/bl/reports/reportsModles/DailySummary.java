package il.co.grauman.kindergarten.bl.reports.reportsModles;

import java.util.Date;
import java.util.List;

public class DailySummary {
    int id;
    Date day;
    String description;

    public DailySummary(Date day, String event,int id) {
        this.id = id;
        this.day = day;
        this.description = event;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    }
