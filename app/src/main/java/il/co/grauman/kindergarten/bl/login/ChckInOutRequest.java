package il.co.grauman.kindergarten.bl.login;

import java.util.Date;

public class ChckInOutRequest {
    Date date;
    String userId;

    public ChckInOutRequest(Date time, String userId) {
        this.date = time;
        this.userId = userId;
    }

    public Date getTime() {
        return date;
    }

    public void setTime(Date time) {
        this.date = time;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
