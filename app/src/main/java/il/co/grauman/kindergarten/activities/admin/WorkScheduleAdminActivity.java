package il.co.grauman.kindergarten.activities.admin;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.admin.AdminFragment.AddWorkerToScheduleDialogFragment;
import il.co.grauman.kindergarten.activities.common.BaseDrawerActivity;

public class WorkScheduleAdminActivity extends BaseDrawerActivity {
    private Spinner spinner;
    String[] bankNames={"BOI","SBI","HDFC","PNB","OBC"};
    private String WorkerName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_arrangemt);
        spinner =(Spinner) findViewById(R.id.spinnerChooseWorker);


        //data for test

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,bankNames);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);

        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                        Object item = parent.getItemAtPosition(pos);
                        WorkerName = item.toString();
                        System.out.println(item.toString());     //prints the text in spinner item.

                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

    }

    @Override
    protected void onResume() {
        super.onResume();
        //getWorkers;
    }


//    @Override
//    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
//        Toast.makeText(getApplicationContext(), bankNames[position], Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> arg0) {
//// TODO Auto-generated method stub
//
//    }


    protected void addWorkerSelect(View view){
        switch (view.getId()){
            case R.id.btnNewWorkSunday:
            case R.id.btnNewWorkModay:
            case R.id.btnNewWorkTuesday:
                FragmentManager fm = getSupportFragmentManager();
                AddWorkerToScheduleDialogFragment addWorkerFragment = AddWorkerToScheduleDialogFragment.newInstance(WorkerName);
                addWorkerFragment.show(fm, "fragment_add_worker");
                break;

        }

        System.out.println(view.getId());
    }



}
