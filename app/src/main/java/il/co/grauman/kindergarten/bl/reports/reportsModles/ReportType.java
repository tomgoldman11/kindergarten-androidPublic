package il.co.grauman.kindergarten.bl.reports.reportsModles;

public enum ReportType {
    DELAYED(1),
    DISEASE(2),
    LACKS(3),
    UNCOMING(4),
    OTHER(5);

    private int value;

    private ReportType(int value) {
        this.value = value;
    }
}
