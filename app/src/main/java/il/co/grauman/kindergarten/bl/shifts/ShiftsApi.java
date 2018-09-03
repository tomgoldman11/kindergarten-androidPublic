package il.co.grauman.kindergarten.bl.shifts;

import il.co.grauman.kindergarten.bl.shifts.shiftModels.DailyShift;
import il.co.grauman.kindergarten.bl.references.StatusResponse;
import retrofit2.Callback;

public interface ShiftsApi {
    void addShift(DailyShift dailyShift, Callback<DailyShift> callback);
    void removeShift(DailyShift dailyShift , Callback<StatusResponse> callback);
    void updateShift(DailyShift oldShift , DailyShift newShift , Callback<StatusResponse> callback);
}
