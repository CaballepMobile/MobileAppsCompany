package com.example.admin.webviewsandsqllite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private WebView wvMain;
    private EditText etName, etNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wvMain = findViewById(R.id.wvMain);
        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);

        WebViewClient wvClient = new WebViewClient();
        WebSettings wvSettings = wvMain.getSettings();
        wvSettings.setJavaScriptEnabled(true);
        wvMain.setWebViewClient(wvClient);
        wvMain.loadUrl("https://google.com");
    }

    public void evtSaveContact(View view) {
        MyContact myContact = new MyContact(etName.getText().toString(), etNumber.getText().toString());
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.SaveNewContact(myContact);
    }

    public void evtDisplayContent(View view) {
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        List<MyContact> contacts = databaseHelper.getContacts();
        for(MyContact contact : contacts){
            Log.d(TAG, contact.getName() + " - " + contact.getNumber());
        }

    }
}