package il.co.grauman.kindergarten.bl.shifts;

import java.util.Date;

public class EmployeeShiftsRequest extends AdminShiftsRequest {
    String userID;

    public EmployeeShiftsRequest(Date day, String userID) {
        super(day);
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    //public void setUserID(String userID) {
    //    this.userID = userID;
    //}
}
