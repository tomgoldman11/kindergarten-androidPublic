package il.co.grauman.kindergarten.bl.reports;

public class EmployeeReportsRequest extends ReportsRequest{
    String userID;

    public EmployeeReportsRequest(int month, int year, String userID) {
        super(month , year);
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
