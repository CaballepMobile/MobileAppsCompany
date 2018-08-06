package com.example.admin.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.admin.myapplication.R;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecurityPermission;

public class MainActivity extends AppCompatActivity {

    EditText etPhoneNumber, etYoutubeID;
    ImageView ivPicture, ivCamPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BindWidgets();
    }

    private void BindWidgets() {
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etYoutubeID = findViewById(R.id.etYoutubeID);
        ivCamPicture = findViewById(R.id.ivCamPicture);
        ivPicture = findViewById(R.id.ivPicture);
    }

    public void evtClick(View view) {
        if (view.getId() == R.id.btnCall) {
            String phoneNumber = etPhoneNumber.getText().toString();
            Call(phoneNumber);

        } else if (view.getId() == R.id.btnYoutube) {
            String videoID = etYoutubeID.getText().toString();
            OpenYoutubeVideo(videoID);
        } else if (view.getId() == R.id.btnMACSite) {
            GoToMobileAppsCompanySite();
        } else if (view.getId() == R.id.btnBringImage) {
            BringImage();
        } else if (view.getId() == R.id.btnDefault) {
            etYoutubeID.setText("g_2VZvi0fQ0");
        } else if (view.getId() == R.id.btnBringPicture){
            BringPicture();
        }

    }

    private void Call(String phoneNumber) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));//change the number

        try {
            startActivity(callIntent);
        } catch (SecurityException exception) {
            Log.d(this.getClass().getSimpleName(), exception.getMessage());
            System.err.println(exception.getMessage());
            Toast.makeText(this, "Calls are not available in your device.", Toast.LENGTH_SHORT).show();
        }


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
        } else
            startActivity(callIntent);

    }

    private void OpenYoutubeVideo(String videoID){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + videoID)));
    }

    private void GoToMobileAppsCompanySite(){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mobileappscompany.com/"));
        startActivity(browserIntent);
    }

    private void BringImage(){
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, 1);
    }

    private void BringPicture(){
        Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(pictureIntent, 2);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK)
            switch (requestCode){
                case 1:
                    Uri selectedImage = data.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                        ivPicture.setImageBitmap(bitmap);
                    } catch (Exception e) {
                        Toast.makeText(this, "Sorry Jason, I really wanted to do this but at least the Gallery opens lol", Toast.LENGTH_LONG).show();
                    }
                    break;

                case 2:
                    Bitmap photo = (Bitmap) data.getExtras().get("data");
                    ivCamPicture.setImageBitmap(photo);
                    break;
            }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Call(etPhoneNumber.getText().toString());
                break;
        }
    }
}