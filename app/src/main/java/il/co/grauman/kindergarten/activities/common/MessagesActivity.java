package il.co.grauman.kindergarten.activities.common;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.common.BaseDrawerActivity;

public class MessagesActivity extends BaseDrawerActivity {

    @Override
    protected int getDrawerItemId() {
        return R.id.messagesMenu;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages_employee);
    }
}
