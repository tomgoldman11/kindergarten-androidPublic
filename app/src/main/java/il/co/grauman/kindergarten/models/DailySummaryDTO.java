package il.co.grauman.kindergarten.models;

import java.util.List;

public class DailySummaryDTO {

    DailySummary dailySummary;
    List<String> picrturesUrl;

    public DailySummaryDTO(DailySummary dailySummary, List<String> picrturesUrl) {
        this.dailySummary = dailySummary;
        this.picrturesUrl = picrturesUrl;
    }

    public DailySummary getDailySummary() {
        return dailySummary;
    }

    public void setDailySummary(DailySummary dailySummary) {
        this.dailySummary = dailySummary;
    }

    public List<String> getPicrturesUrl() {
        return picrturesUrl;
    }

    public void setPicrturesUrl(List<String> picrturesUrl) {
        this.picrturesUrl = picrturesUrl;
    }
}
