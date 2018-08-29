package il.co.grauman.kindergarten.bl.shifts;

import java.util.Date;

public class ShiftRequest {
    String userId;
    Date day;
    public ShiftRequest(Date day) {
        this.day=day;
    }

    public ShiftRequest(String userId, Date day) {
        this.userId = userId;
        this.day = day;
    }

    public String getUserId() {
        return userId;
    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }

    public Date getDay() {
        return day;
    }

//    public void setDay(Date day) {
//        Day = day;
//    }
}
