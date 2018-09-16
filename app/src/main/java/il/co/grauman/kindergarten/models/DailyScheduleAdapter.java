package il.co.grauman.kindergarten.models;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import il.co.grauman.kindergarten.R;

public class DailyScheduleAdapter extends RecyclerView.Adapter<DailyScheduleAdapter.DailyScheduleViewHolder> {
    private Context context;
    private List<Agenda> dailyActivities;

    public DailyScheduleAdapter(Context context, List<Agenda> dailyActivities){
        this.context = context;
        this.dailyActivities = dailyActivities;
    }
    @NonNull
    @Override
    public DailyScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.activity_daily_schedule_item,null);
        DailyScheduleViewHolder dailyScheduleViewHolder = new DailyScheduleViewHolder(view);
        return dailyScheduleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DailyScheduleViewHolder dailyScheduleViewHolder, int position) {
        Agenda currentActivity = dailyActivities.get(position);
        dailyScheduleViewHolder.activityData.setText("  " + currentActivity.getDescription());
        dailyScheduleViewHolder.activityHour.setText("  " + currentActivity.getDate());
    }

    @Override
    public int getItemCount() {
        return dailyActivities.size();
    }

    public class DailyScheduleViewHolder extends RecyclerView.ViewHolder{
        TextView activityData;
        TextView activityHour;

        public DailyScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
            activityHour = itemView.findViewById(R.id.activityHour);
            activityData = itemView.findViewById(R.id.activityData);

        }
    }
}
