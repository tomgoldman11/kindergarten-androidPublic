package il.co.grauman.kindergarten.bl.shifts;

public class WorkWeekSchedule {


    private static WorkScheduleApi instance;

    public static WorkScheduleApi getInstance() {
//        if (instance == null) {
//            instance = new WorkScheduleApi() {
//
//                @Override
//                public void getWorkSchedule(String userId, Date day, Callback<List<DailyShift>> callback) {
//                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
//                            .getApi().getWorkSchedule(new EmployeeShiftsRequest(day, userId)));
//                }
//
//                @Override
//                public void getWorkSchedule(Date day, Callback<List<DailyShift>> callback) {
//                    ApiImplementation.apiImplementation(callback, () -> RetrofitInstance.getInstance()
//                            .getApi().getWorkSchedule("011",day,callback);
//                }
//            };
//        }
//        return  instance;
        return instance;
    }
}
