package il.co.grauman.kindergarten.activities.common;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import il.co.grauman.kindergarten.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment implements BaseFragment{

    private TextView testTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_admin_settings, container, false);
        testTextView = fragmentView.findViewById(R.id.testTextView);
        return fragmentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        testTextView.setText("Settings view");
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public String getTitle(Context context) {
        return context.getString(R.string.settings);
    }
}
