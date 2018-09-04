package il.co.grauman.kindergarten.models;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import il.co.grauman.kindergarten.R;

public class DailySummaryAdapter extends RecyclerView.Adapter<DailySummaryAdapter.DailySummaryViewHolder> {
    private Context context;
    private List<DailySummaryEvent> dailySummary;

    public DailySummaryAdapter(Context context, List<DailySummaryEvent> dailyActivities){
        this.context = context;
        this.dailySummary = dailyActivities;
    }
    @NonNull
    @Override
    public DailySummaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.daily_summary_item,null);
        DailySummaryViewHolder dailyScheduleViewHolder = new DailySummaryViewHolder(view);
        return dailyScheduleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DailySummaryViewHolder dailySummaryViewHolder, int position) {
        DailySummaryEvent currentActivity = dailySummary.get(position);
        ArrayList images = currentActivity.getEventImages();

        dailySummaryViewHolder.title.setText("  " + currentActivity.getEventName());
        dailySummaryViewHolder.description.setText("  " + currentActivity.getEventDescription());

        Picasso.get().load(images.get(0).toString()).into(dailySummaryViewHolder.leftImage);
        Picasso.get().load(images.get(1).toString()).into(dailySummaryViewHolder.centerImage);
        Picasso.get().load(images.get(2).toString()).into(dailySummaryViewHolder.rightImage);
    }

    @Override
    public int getItemCount() {
        return dailySummary.size();
    }

    public class DailySummaryViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView description;
        ImageView leftImage;
        ImageView centerImage;
        ImageView rightImage;

        public DailySummaryViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            leftImage = itemView.findViewById(R.id.leftImage);
            centerImage = itemView.findViewById(R.id.centerImage);
            rightImage = itemView.findViewById(R.id.rightImage);

        }
    }
}
