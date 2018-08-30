package il.co.grauman.kindergarten.activities.user;

import android.content.Context;

import il.co.grauman.kindergarten.activities.common.BaseFragment;
import il.co.grauman.kindergarten.activities.common.CalendarScheduleFragment;

public class UserCalendar extends CalendarScheduleFragment  {
    @Override
    public String getTitle(Context context) {
        return "לוז שנתי להורים";
    }
}
