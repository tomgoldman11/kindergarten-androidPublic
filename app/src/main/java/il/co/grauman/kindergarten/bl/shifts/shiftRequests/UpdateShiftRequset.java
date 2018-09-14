package il.co.grauman.kindergarten.bl.shifts.shiftRequests;

import il.co.grauman.kindergarten.bl.shifts.shiftModels.DailyShift;
import il.co.grauman.kindergarten.models.Shift;

public class UpdateShiftRequset {
    Shift newShift , oldShift;

    public UpdateShiftRequset(Shift newShift, Shift oldShift) {
        this.newShift = newShift;
        this.oldShift = oldShift;
    }

    public Shift getNewShift() {
        return newShift;
    }

    public void setNewShift(Shift newShift) {
        this.newShift = newShift;
    }

    public Shift getOldShift() {
        return oldShift;
    }

    public void setOldShift(Shift oldShift) {
        this.oldShift = oldShift;
    }
}
