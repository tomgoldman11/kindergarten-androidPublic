package il.co.grauman.kindergarten.bl.shifts.shiftRequests;

import java.util.Date;

public class AdminShiftsRequest {
    Date day;
    public AdminShiftsRequest(Date day) {
        this.day=day;
    }

    public Date getDay() {
        return day;
    }

//    public void setDay(Date day) {
//        Day = day;
//    }
}
