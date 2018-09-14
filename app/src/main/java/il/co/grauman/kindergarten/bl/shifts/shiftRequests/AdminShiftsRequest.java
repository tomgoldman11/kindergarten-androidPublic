package il.co.grauman.kindergarten.bl.shifts.shiftRequests;

import java.util.Date;

public class AdminShiftsRequest {
    String userID;
    String day;
    public AdminShiftsRequest(String day) {
        this.day=day;
    }

    public String getDay() {
        return day;
    }

//    public void setDay(Date day) {
//        Day = day;
//    }
}
