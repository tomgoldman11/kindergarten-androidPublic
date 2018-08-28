package il.co.grauman.kindergarten.bl;

import java.util.Date;

class Schedule {
    String userId;
    Date day;
    public Schedule(Date day) {
        this.day=day;
    }

    public Schedule(String userId, Date day) {
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
