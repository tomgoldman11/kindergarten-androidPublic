package il.co.grauman.kindergarten.activities.admin;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import il.co.grauman.kindergarten.R;
import il.co.grauman.kindergarten.activities.common.DailySummaryActivity;
import il.co.grauman.kindergarten.bl.reports.ReportSheets;
import il.co.grauman.kindergarten.bl.reports.reportsModles.DailySummary;
import il.co.grauman.kindergarten.models.DateManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddEventFragment extends Fragment {
    TextView date;
    ImageView arrowRight;
    ImageView arrowLeft;
    ImageView saveBtn;
    ScrollView newImages;
    Button addNewImageBtn;
    EditText eventDescription;
    LinearLayout dynamicImagesLayout;
    List<byte[]> images = new ArrayList<byte[]>();
    private static final int GALLERY_REQUEST = 1;
    DateManager dateManager;

    public AddEventFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_add_event, container, false);
    }

    public void onStart() {

        super.onStart();

        // Inflate the layout for this fragment
        setUIElements();

        dateManager = new DateManager(date, arrowRight, arrowLeft);

        addNewImageBtn.setOnClickListener(v -> {
            openGallery();
        });
        saveBtn.setOnClickListener(v -> {
            saveEvent();
        });
    }

    private void saveEvent(){
        String description = eventDescription.getText().toString();
//        Toast.makeText(getContext(), description.toString(), Toast.LENGTH_LONG).show();
//        Toast.makeText(getContext(), images.toString(), Toast.LENGTH_LONG).show();
        //ReportSheets.getInstace().setDailySchedule(description, images);
    }

    private void openGallery(){
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK)
            switch (requestCode){
                case GALLERY_REQUEST:
                    Uri selectedImage = data.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), selectedImage);
                        addNewImageViewToScrollView(bitmap);
                        byte[] byteArray = convertImageFromBitmapToBytes(bitmap);
                        images.add(byteArray);
                        //bitmap.recycle();

                    } catch (IOException e) {
                        Log.i("TAG", "Some exception " + e);
                    }
                    break;
            }
    }
    private byte[] convertImageFromBitmapToBytes(Bitmap bitmap){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
    private void addNewImageViewToScrollView(Bitmap bitmap){
        ImageView currentImage = new ImageView(getContext());
        currentImage.setImageBitmap(bitmap);
        dynamicImagesLayout.addView(currentImage);
    }


    private void setUIElements(){
        date = getView().findViewById(R.id.tvDate);
        arrowRight = getView().findViewById(R.id.ivRightArrow);
        arrowLeft = getView().findViewById(R.id.ivLeftArrow);
        eventDescription = getView().findViewById(R.id.etNew_event4);
        saveBtn = getView().findViewById(R.id.ibSave4);
        newImages = getView().findViewById(R.id.summary);
        dynamicImagesLayout = getView().findViewById(R.id.linearLayoutDynamicImages);
        addNewImageBtn = getView().findViewById(R.id.addNewImage);
    }

}
