package il.co.grauman.kindergarten.activities.admin.AdminFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import il.co.grauman.kindergarten.R;

public class AddWorkerToScheduleDialogFragment extends DialogFragment {
    String[] hours = {"9:00","9:15","9:30","9:45",
                    "10:00","10:15","10:30","10:45",
                    "11:00","11:15","11:30","11:45",
                    "12:00","12:15","12:30","12:45",
                    "13:00","13:15","13:30","13:45",
                    "14:00","14:15","14:30","14:45",
                    "15:00","15:15","15:30","15:45",
                    "16:00","16:15","16:30","16:45",
                    "17:00","17:15","17:30","17:45",
                    "18:00"};
    ArrayList<String> hoursTo = new ArrayList<String>();
    View view;
    private Spinner spinnerFrom;
    private Spinner spinnerTo;
    private static String workerName;
    private String DateFrom;
    private String DateTo;
    ArrayAdapter we ;

    public static AddWorkerToScheduleDialogFragment newInstance(String title) {
        AddWorkerToScheduleDialogFragment frag = new AddWorkerToScheduleDialogFragment();
        workerName = title;
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView thechoosenDate ;
        view = inflater.inflate(R.layout.fragment_add_worker_arrangement, container);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView workerNamefield = getView().findViewById(R.id.WorkerInfo);
        workerNamefield.setText(workerName);

        spinnerFrom = (Spinner) view.findViewById(R.id.spinnerFrom);
        spinnerTo = (Spinner) view.findViewById(R.id.spinnerTO);
        we = new ArrayAdapter(view.getContext(),android.R.layout.simple_spinner_item,hours);
        we.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        System.out.print(we);
        spinnerFrom.setAdapter(we);

        spinnerFrom.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                        Object item = parent.getItemAtPosition(pos);
                        DateFrom = item.toString();
                        int flag = 0;
                        for (String hour : hours) {
                            if(flag ==1)
                                hoursTo.add(hour);
                            if(hour == DateFrom){
                              flag = 1;

                            }

                        }
                        System.out.println(item.toString());
//                        setAdapter();
                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });


        spinnerTo.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                        Object item = parent.getItemAtPosition(pos);
                        DateTo = item.toString();

                        System.out.println(item.toString());

                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


    }
    private void setAdapter(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item,
                hoursTo);
        spinnerTo.setAdapter(adapter);
    }
    private void CloseFragment(){
        this.dismiss();
    }


}
