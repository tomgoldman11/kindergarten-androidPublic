package il.co.grauman.kindergarten.bl.reports.reportsModles;

public class Report {
    String parentID , workerID , text;
    ReportType type;

    public Report(String parentID, String workerID, String text, ReportType type) {
        this.parentID = parentID;
        this.workerID = workerID;
        this.text = text;
        this.type = type;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public String getWorkerID() {
        return workerID;
    }

    public void setWorkerID(String workerID) {
        this.workerID = workerID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ReportType getType() {
        return type;
    }

    public void setType(ReportType type) {
        this.type = type;
    }
}
