package il.co.grauman.kindergarten.bl.reports;

import java.util.Date;

public class WorkHours {
    String userId;
    Date checkInHour, checkOutHour;

    public WorkHours(String userId, Date checkInHour, Date checkOutHour) {
        this.userId = userId;
        this.checkInHour = checkInHour;
        this.checkOutHour = checkOutHour;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCheckInHour() {
        return checkInHour;
    }

    public void setCheckInHour(Date checkInHour) {
        this.checkInHour = checkInHour;
    }

    public Date getCheckOutHour() {
        return checkOutHour;
    }

    public void setCheckOutHour(Date checkOutHour) {
        this.checkOutHour = checkOutHour;
    }
}
