package il.co.grauman.kindergarten.activities.common;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.models.DateManager;
import il.co.grauman.kindergarten.models.DailySummaryAdapter;
import il.co.grauman.kindergarten.models.DailySummaryEvent;

public class DailySummaryActivity extends BaseDrawerActivity {
    TextView date;
    ScrollView summary;
    ImageView arrowRight;
    ImageView arrowLeft;
    TextView description;
    LinearLayout DynamicImagesLayout;

    private RecyclerView mRecyclerView;
    private DailySummaryAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_summary);

        setUIElements();

        DateManager dateManager = new DateManager(date, arrowRight, arrowLeft);

        setSummary();

        Button addEventButton = findViewById(R.id.btnNewEvent);
        //Fragment frag = new AddEventFragment();
        //addEventButton.setOnClickListener(v -> NavigateToFragment(frag) );
    }

    private void NavigateToFragment(Fragment newFragment){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.subLayout, newFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();
    }

    private void setUIElements(){
        date = findViewById(R.id.date);
        summary = findViewById(R.id.summary);
        description = findViewById(R.id.description);
        arrowRight = findViewById(R.id.rightArrow);
        arrowLeft = findViewById(R.id.leftArrow);
        DynamicImagesLayout = (LinearLayout) findViewById(R.id.linearLayoutDynamicImages);
    }

    private void setSummary(){
        // TO-DO: ADD THE FUNCTION THAT GETS DATA FROM BL FOR THE DAILY SUMMARY

        // STATIC DATA FOR NOW
        String newDate = "20/03/2030";
        String newDescription = "כולם חוגגים תראו איזה כיף!";
        String link1 = "https://www.srugim.co.il/i/wp-content/uploads/2018/03/F170312HP16__w650h331q80.jpg";
        String link2 = "http://parenting.firstcry.com/wp-content/uploads/2018/03/1010723275-H.jpg";
        String link3 = "https://scontent.flhr5-1.fna.fbcdn.net/v/t1.0-9/20915594_10213548956139858_193278364128869272_n.jpg?_nc_cat=0&oh=ce5433c75303f63b9feded523bbb4a1d&oe=5BF8A016";

        ArrayList<String> images = new ArrayList<>();
        images.add(link1);
        images.add(link2);
        images.add(link3);

        DailySummaryEvent newEvent = new DailySummaryEvent(newDate, newDescription, images);
        // TODO: use BL.getDailySum method

        // STATIC DATA FOR NOW

        // get data from dailysummary class object
        String eventDate = newEvent.getEventDate();
        String eventDescription = newEvent.getEventDescription();
        ArrayList<String> eventImages = newEvent.getEventImages();

        description.setText(eventDescription);

        for(int i = 0 ; i < eventImages.size(); i++) {
            ImageView currentImage = new ImageView(DailySummaryActivity.this);
            DynamicImagesLayout.addView(currentImage);
            Picasso.get().load(eventImages.get(i).toString()).into(currentImage);
        }
    }



//    private void setSummary(){
//        ArrayList<DailySummaryEvent> dailyActivities = new ArrayList<DailySummaryEvent>();
//
//        //TO-DO: ADD THE FUNCTION THAT GETS DATA FROM BL FOR THE DAILY SUMMARY
//
//        // STATIC DATA FOR NOW
//        String title1 = "מסיבת פורים";
//        String description1 = "כולם חוגגים תראו איזה כיף!";
//        String link1 = "https://www.srugim.co.il/i/wp-content/uploads/2018/03/F170312HP16__w650h331q80.jpg";
//        String title2 = "ליואל יש יומולדת";
//        String description2 = "יואל הגבר חגג אתמול יומולדת 5";
//        String link2 = "http://parenting.firstcry.com/wp-content/uploads/2018/03/1010723275-H.jpg";
//        String title3 = "סקראם עם כולם";
//        String description3 = "גילעד יש חסמים כלשהם?";
//        String link3 = "https://scontent.flhr5-1.fna.fbcdn.net/v/t1.0-9/20915594_10213548956139858_193278364128869272_n.jpg?_nc_cat=0&oh=ce5433c75303f63b9feded523bbb4a1d&oe=5BF8A016";
//
//        dailyActivities.add(new DailySummaryEvent(title1,description1, link1, link1, link1));
//        dailyActivities.add(new DailySummaryEvent(title2,description2, link2, link2, link2));
//        dailyActivities.add(new DailySummaryEvent(title3,description3, link3, link3, link3));
//
//        mAdapter = new DailySummaryAdapter(this, dailyActivities);
//
//        mRecyclerView = summary;
//        mLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//
//        mRecyclerView.setAdapter(mAdapter);
//
//    }


}
