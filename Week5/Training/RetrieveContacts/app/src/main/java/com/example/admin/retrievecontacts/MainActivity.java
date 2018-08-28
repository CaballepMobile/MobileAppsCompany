package com.example.admin.retrievecontacts;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 10; //Not a special value
    public static final String TAG = "MainActivity_LOG";
    private EditText etContactName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etContactName = findViewById(R.id.etContactName);

        checkPermissions();
    }

    public void evtMainActivity(View view) {

        Uri contentUri = ContactsContract.Contacts.CONTENT_URI;
        String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
        String HAS_PHONE_NUMBER = ContactsContract.Contacts.HAS_PHONE_NUMBER;

        String selection = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME+" like '%" + etContactName.getText() + "%'";

        Cursor cursor = getContentResolver().query(contentUri, null, null, null, null, null);

        int hasPhone = 0;


        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {

                //Specific contact
                String CONTACT_NAME = etContactName.getText().toString();

                //Getting all the contacts
                //String CONTACT_NAME = cursor.getString(cursor.getColumnIndex(DISPLAY_NAME));

                Log.d(TAG, "evtMainActivity: " + CONTACT_NAME);

                hasPhone = Integer.parseInt(cursor.getString(cursor.getColumnIndex(HAS_PHONE_NUMBER)));
                if (hasPhone > 0) {
                    Uri phoneURI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

                    String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;

                    String[] projection = new String[]{NUMBER};
                    String selection = DISPLAY_NAME + "=?";
                    String[] selectionArgs = new String[]{CONTACT_NAME};

                    Cursor phoneCursor = getContentResolver().query(phoneURI, projection, selection, selectionArgs, null);

                    while (phoneCursor.moveToNext()) {
                        Log.d(TAG, "evtMainActivity: " + phoneCursor.getString(phoneCursor.getColumnIndex(NUMBER)));
                    }
                }
            }
        }
    }

    private void checkPermissions() {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            //Show explanation
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)) {
                Log.d(TAG, "checkPermissions: ");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            } else {
                Log.d(TAG, "checkPermissions: Requesting permission");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            }

        } else {

            Log.d(TAG, "checkPermissions: Permission is already granted");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch(requestCode){
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Log.d(TAG, "onRequestPermissionsResult: Granted");
                } else {
                    Log.d(TAG, "onRequestPermissionsResult: Denied");
                }
                break;
        }
    }
}
