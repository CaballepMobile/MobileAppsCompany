package com.example.admin.daily4;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.security.SecurityPermission;

public class MainActivity extends AppCompatActivity {

    EditText etPhoneNumber, etYoutubeID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BindWidgets();
    }

    private void BindWidgets() {
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etYoutubeID = findViewById(R.id.etYoutubeID);
    }

    public void evtClick(View view) {
        if (view.getId() == R.id.btnCall) {
            String phoneNumber = etPhoneNumber.getText().toString();
            Call(phoneNumber);

        } else if (view.getId() == R.id.btnYoutube) {
            String videoID = etYoutubeID.getText().toString();
            OpenYoutubeVideo(videoID);
        } else if (view.getId() == R.id.btnMACSite){
            GoToMobileAppsCompanySite();
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
        startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
    }
}