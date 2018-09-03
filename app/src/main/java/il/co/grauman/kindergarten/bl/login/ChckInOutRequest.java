package il.co.grauman.kindergarten.bl.login;

import java.util.Date;

public class ChckInOutRequest {
    Date time;
    String userId;

    public ChckInOutRequest(Date time, String userId) {
        this.time = time;
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
