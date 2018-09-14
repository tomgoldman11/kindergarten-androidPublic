package il.co.grauman.kindergarten.bl.shifts;


import il.co.grauman.kindergarten.bl.references.ApiImplementation;
import il.co.grauman.kindergarten.bl.references.RetrofitInstance;
import il.co.grauman.kindergarten.bl.shifts.ShiftsApi;
import il.co.grauman.kindergarten.bl.shifts.shiftModels.DailyShift;
import il.co.grauman.kindergarten.bl.references.StatusResponse;
import il.co.grauman.kindergarten.bl.shifts.shiftRequests.UpdateShiftRequset;
import il.co.grauman.kindergarten.models.Shift;

public class UpdateShift {

    private static ShiftsApi instance;

    public static ShiftsApi getInstance() {
        if (instance == null) {
            instance = new ShiftsApi() {

                @Override
                public void addShift(Shift dailyShift, retrofit2.Callback<Shift> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().addShift(dailyShift));
                }

                @Override
                public void removeShift(Shift dailyShift, retrofit2.Callback<StatusResponse> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().removeShift(dailyShift));
                }


                @Override
                public void updateShift(Shift oldShift, Shift newShift, retrofit2.Callback<Shift> callback) {
                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
                            .getApi().updateShift(new UpdateShiftRequset(newShift, oldShift)));
                }
            };
        }
        return instance;
    }
}
//package il.co.grauman.kindergarten.bl.shifts;
//
//
//import javax.security.auth.callback.Callback;
//
//public class UpdateShift {
//
//    public void adminAddShift(DailyShift dailyShift, Callback<>){
//
//    }
//
//    public void adminRemoveShift(DailyShift dailyShift){
//
//    }
//
//}
