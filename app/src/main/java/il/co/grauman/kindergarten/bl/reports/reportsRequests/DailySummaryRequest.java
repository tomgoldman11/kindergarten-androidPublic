package il.co.grauman.kindergarten.bl.reports.reportsRequests;

import java.util.List;

import il.co.grauman.kindergarten.bl.reports.reportsModles.DailySummary;

public class DailySummaryRequest {
    DailySummary dailySummary;
    List<Byte [] > picture;

    public DailySummaryRequest(DailySummary dailySummary, List<Byte[]> picture) {
        this.dailySummary = dailySummary;
        this.picture = picture;
    }

    public DailySummary getDailySummary() {
        return dailySummary;
    }

    public void setDailySummary(DailySummary dailySummary) {
        this.dailySummary = dailySummary;
    }

    public List<Byte[]> getPicture() {
        return picture;
    }

    public void setPicture(List<Byte[]> picture) {
        this.picture = picture;
    }
}
