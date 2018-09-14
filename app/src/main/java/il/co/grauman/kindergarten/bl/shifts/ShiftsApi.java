package il.co.grauman.kindergarten.bl.shifts;

import il.co.grauman.kindergarten.bl.shifts.shiftModels.DailyShift;
import il.co.grauman.kindergarten.bl.references.StatusResponse;
import il.co.grauman.kindergarten.bl.shifts.shiftRequests.UpdateShiftRequset;
import il.co.grauman.kindergarten.models.Shift;
import retrofit2.Callback;

public interface ShiftsApi {
    void addShift(Shift dailyShift, Callback<Shift> callback);
    void removeShift(Shift dailyShift , Callback<StatusResponse> callback);
    void updateShift(Shift oldShift , Shift newShift , Callback<Shift> callback);
}
