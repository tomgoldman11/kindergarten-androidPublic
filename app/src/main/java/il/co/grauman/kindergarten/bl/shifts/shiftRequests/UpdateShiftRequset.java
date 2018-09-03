package il.co.grauman.kindergarten.bl.shifts.shiftRequests;

import il.co.grauman.kindergarten.bl.shifts.shiftModels.DailyShift;

public class UpdateShiftRequset {
    DailyShift newShift , oldShift;

    public UpdateShiftRequset(DailyShift newShift, DailyShift oldShift) {
        this.newShift = newShift;
        this.oldShift = oldShift;
    }

    public DailyShift getNewShift() {
        return newShift;
    }

    public void setNewShift(DailyShift newShift) {
        this.newShift = newShift;
    }

    public DailyShift getOldShift() {
        return oldShift;
    }

    public void setOldShift(DailyShift oldShift) {
        this.oldShift = oldShift;
    }
}
