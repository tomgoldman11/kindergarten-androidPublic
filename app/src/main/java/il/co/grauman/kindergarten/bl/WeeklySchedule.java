package il.co.grauman.kindergarten.bl;

import java.util.List;

public class WeeklySchedule {
    List<DailySchedule> workWeek;
    String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public WeeklySchedule(List<DailySchedule> workWeek, String userId) {
        this.workWeek = workWeek;
        this.userId = userId;
    }

    public List<DailySchedule> getWorkWeek() {
        return workWeek;
    }

    public void setWorkWeek(List<DailySchedule> workWeek) {
        this.workWeek = workWeek;
    }
}
