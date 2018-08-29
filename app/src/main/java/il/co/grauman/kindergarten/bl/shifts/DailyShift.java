package il.co.grauman.kindergarten.bl.shifts;

import java.util.Date;

class DailyShift {
    String userId;
    Date beginShift;
    Date finshShift;

    public DailyShift() {}

    public DailyShift(String userId, Date beginShift, Date finshShift) {
        this.userId = userId;
        this.beginShift = beginShift;
        this.finshShift = finshShift;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getBeginShift() {
        return beginShift;
    }

    public void setBeginShift(Date beginShift) {
        this.beginShift = beginShift;
    }

    public Date getFinshShift() {
        return finshShift;
    }

    public void setFinshShift(Date finshShift) {
        this.finshShift = finshShift;
    }
}
