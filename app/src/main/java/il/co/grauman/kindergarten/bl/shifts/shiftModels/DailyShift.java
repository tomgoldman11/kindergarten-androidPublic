package il.co.grauman.kindergarten.bl.shifts.shiftModels;

import java.util.Date;

public class DailyShift {
    //shift ID
    int id;
    String userId;
    Date beginShift;
    Date finshShift;

    public DailyShift() {}

    public DailyShift(int id, String userId, Date beginShift, Date finshShift) {
        this.id = id;
        this.userId = userId;
        this.beginShift = beginShift;
        this.finshShift = finshShift;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
