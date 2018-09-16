package il.co.grauman.kindergarten.bl.reports.reportsModles;

import java.util.List;

public class DailySummaryDTO {
    DailySummary dailySummary;
    List<String> pictures;

    public DailySummaryDTO(DailySummary dailySummary, List<String> pictures) {
        this.dailySummary = dailySummary;
        this.pictures = pictures;
    }

    public DailySummary getDailySummary() {
        return dailySummary;
    }

    public void setDailySummary(DailySummary dailySummary) {
        this.dailySummary = dailySummary;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }
}
