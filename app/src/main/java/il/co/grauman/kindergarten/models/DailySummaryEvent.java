package il.co.grauman.kindergarten.models;

import android.media.Image;
import android.widget.ImageView;

import java.util.ArrayList;

public class DailySummaryEvent {
    String title;
    String description;
    String leftImage;
    String centerImage;
    String rightImage;

    public DailySummaryEvent(String name, String description, String leftImage, String centerImage, String rightImage){
        this.title = name;
        this.description = description;
        this.leftImage = leftImage;
        this.centerImage = centerImage;
        this.rightImage = rightImage;
    }

    public String getEventName(){
        return title;
    }

    public String getEventDescription(){
        return description;
    }

    public ArrayList getEventImages(){
        ArrayList images = new ArrayList<String>();
        images.add(leftImage);
        images.add(centerImage);
        images.add(rightImage);
        return images;
    }

}
