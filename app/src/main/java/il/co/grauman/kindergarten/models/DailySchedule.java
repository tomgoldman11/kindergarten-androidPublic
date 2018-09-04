package il.co.grauman.kindergarten.models;

public class DailySchedule {
    String hour;
    String activityData;

    public DailySchedule(String hours, String activity){
        this.activityData = activity;
        this.hour = hours;
    }
    public String getDailyActivityData(){
        return activityData;
    }
    public String getDailyActivityHour(){
        return hour;
    }
}
