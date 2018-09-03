package il.co.grauman.kindergarten.bl.shifts;


import il.co.grauman.kindergarten.bl.references.ApiImplementation;
import il.co.grauman.kindergarten.bl.references.RetrofitInstance;
import il.co.grauman.kindergarten.bl.shifts.shiftModels.DailyShift;
import il.co.grauman.kindergarten.bl.references.StatusResponse;
import il.co.grauman.kindergarten.bl.shifts.shiftRequests.UpdateShiftRequset;

public class UpdateShift implements ShiftsApi {

    @Override
    public void addShift(DailyShift dailyShift, retrofit2.Callback<DailyShift> callback) {
        ApiImplementation.apiImplementation(callback , () -> RetrofitInstance.getInstance()
        .getApi().addShift(dailyShift));
    }

    @Override
    public void removeShift(DailyShift dailyShift , retrofit2.Callback<StatusResponse> callback){
        ApiImplementation.apiImplementation(callback , ()-> RetrofitInstance.getInstance()
        .getApi().removeShift(dailyShift));
    }


    @Override
    public void updateShift(DailyShift oldShift , DailyShift newShift , retrofit2.Callback<StatusResponse> callback) {
        ApiImplementation.apiImplementation(callback , ()->RetrofitInstance.getInstance()
        .getApi().updateShift(new UpdateShiftRequset(newShift, oldShift)));
    }
}
