package il.co.grauman.kindergarten.models;

import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateManager {
    java.util.Calendar calendar;
    Date currentDate;
    SimpleDateFormat dateFormat;
    TextView date;
    ImageView goToNextDay;
    ImageView goToPrevDay;

    public DateManager(TextView date, ImageView goToNextDay, ImageView goToPrevDay){
        calendar = java.util.Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        this.date = date;
        this.goToNextDay = goToNextDay;
        this.goToPrevDay = goToPrevDay;

        displayDate();
        goToNextDate();
        goToPrevDate();
    }

    public void setDate(int daysChange){
        calendar.add(java.util.Calendar.DAY_OF_YEAR, daysChange);
        displayDate();
    }

    public void displayDate(){
        currentDate = calendar.getTime();
        String formattedDate = dateFormat.format(currentDate);
        date.setText(formattedDate);
    }

    public void goToNextDate(){
        goToNextDay.setOnClickListener(v -> setDate(1));
    }
    public void goToPrevDate(){
        goToPrevDay.setOnClickListener(v -> setDate(-1));
    }
}
