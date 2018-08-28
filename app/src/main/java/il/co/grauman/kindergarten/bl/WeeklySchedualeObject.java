package il.co.grauman.kindergarten.bl;

import java.util.List;

public class WeeklySchedualeObject {
    List<DailySchedualeObject> workWeek;
    String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public WeeklySchedualeObject(List<DailySchedualeObject> workWeek, String userId) {
        this.workWeek = workWeek;
        this.userId = userId;
    }

    public List<DailySchedualeObject> getWorkWeek() {
        return workWeek;
    }

    public void setWorkWeek(List<DailySchedualeObject> workWeek) {
        this.workWeek = workWeek;
    }
}
