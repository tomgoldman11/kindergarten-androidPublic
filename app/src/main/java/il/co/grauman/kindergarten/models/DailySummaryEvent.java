package il.co.grauman.kindergarten.models;

import android.media.Image;
import android.widget.ImageView;

import java.util.ArrayList;

public class DailySummaryEvent {
    String date;
    String description;
    ArrayList<String> images;


    public DailySummaryEvent(String date, String description, ArrayList<String> images){
        this.date = date;
        this.description = description;
        this.images = images;
    }

    public String getEventDate(){
        return date;
    }

    public String getEventDescription(){
        return description;
    }

    public ArrayList<String> getEventImages(){
        return images;
    }

}
