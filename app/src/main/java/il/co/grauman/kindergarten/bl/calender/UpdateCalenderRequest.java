package il.co.grauman.kindergarten.bl.calender;

public class UpdateCalenderRequest {
    YearSchedule oldSchedule , newSchedule;

    public UpdateCalenderRequest(YearSchedule oldSchedule, YearSchedule newSchedule) {
        this.oldSchedule = oldSchedule;
        this.newSchedule = newSchedule;
    }

    public YearSchedule getOldSchedule() {
        return oldSchedule;
    }

    public void setOldSchedule(YearSchedule oldSchedule) {
        this.oldSchedule = oldSchedule;
    }

    public YearSchedule getNewSchedule() {
        return newSchedule;
    }

    public void setNewSchedule(YearSchedule newSchedule) {
        this.newSchedule = newSchedule;
    }
}
