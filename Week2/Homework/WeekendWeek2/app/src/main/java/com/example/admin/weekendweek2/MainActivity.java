package com.example.admin.weekendweek2;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.weekendweek2.Fragments.MyDialogFragment;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void evtMainActivityButtonsOnClick(View view) {
        int viewId = view.getId();
        switch (viewId) {
            case R.id.btnGoToPDFViewer:
                GoToPDFActivity();
                break;

            case R.id.btnGoToTwoFragmentCounter:
                GoToTwoFragmentsActivity();
                break;

            //ALERTS AND DIALOGS

            case R.id.btnShowDialogFragment:
                ShowDialogFragment();
                break;

            case R.id.btnShowDefaultAlert:
                ShowDefaultAlert();
                break;

            case R.id.btnShowCustomAlert:
                ShowCustomAlert();
                break;

            case R.id.btnShowListAlert:
                ShowListAlert();
                break;

            case R.id.btnSendMessage:
                SendMessage();
                break;

            case R.id.btnNotifyAndroid:
                NotifyAndroid();
                break;
        }
    }

    private void ShowDialogFragment() {

        int delay = 4000;
        final MyDialogFragment myDialogFragment = new MyDialogFragment();
        myDialogFragment.show(getSupportFragmentManager(), "myDialogFragment");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(0); //Not necessary
                    myDialogFragment.dismiss();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, delay);
    }

    private void ShowDefaultAlert() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("Example Title");
        alertDialogBuilder.setMessage("Example Message!");
        alertDialogBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "That was an Alert Dialog (Default)", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialogBuilder.show();
    }

    private void ShowCustomAlert() {
        final AlertDialog dialog;
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_custom, null);

        final EditText etName = view.findViewById(R.id.etName_dialog_custom);
        Button btnYes = view.findViewById(R.id.btnYes_dialog_custom);
        Button btnNo = view.findViewById(R.id.btnNo_dialog_custom);

        final AlertDialog.Builder alerDialogBuilder = new AlertDialog.Builder(this);
        alerDialogBuilder.setTitle("Info");
        alerDialogBuilder.setView(view);
        alerDialogBuilder.setCancelable(false);
        dialog = alerDialogBuilder.create();

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "I am grateful " + etName.getText().toString(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Oh yeah? well I hate you " + etName.getText().toString(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void ShowListAlert() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Who's your favorite Avenger?");

        List<String> avengersList = Arrays.asList(getResources().getStringArray(R.array.avengers_names));
        final ArrayAdapter avengersArrayAdapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_singlechoice, avengersList);

        alertDialogBuilder.setAdapter(avengersArrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String resultMessage;
                String favoriteAvenger = avengersArrayAdapter.getItem(which).toString();
                if (favoriteAvenger.equals("Black Widow")) {
                    resultMessage = "Dude!, " + favoriteAvenger + " is my favorite Avenger too!";
                } else {
                    resultMessage = favoriteAvenger + " is cool!";
                }
                Toast.makeText(MainActivity.this, resultMessage, Toast.LENGTH_SHORT).show();
            }
        });

        alertDialogBuilder.show();

    }

    private void SendMessage(){

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {

            if (checkSelfPermission(Manifest.permission.SEND_SMS)
                    == PackageManager.PERMISSION_DENIED) {

                Log.d("permission", "permission denied to SEND_SMS - requesting it");
                String[] permissions = {Manifest.permission.SEND_SMS};

                requestPermissions(permissions, 1);

            }
        }

        EditText etMessage = findViewById(R.id.etMessage);
        EditText etPhoneNumber = findViewById(R.id.etPhoneNumber);

        String message = etMessage.getText().toString();
        String phoneNumber = etPhoneNumber.getText().toString();

        SmsManager smsManager = SmsManager.getDefault();
        try
        {
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            Toast.makeText(getApplicationContext(), "Sending...", Toast.LENGTH_LONG).show();
            //Maybe something to know if that went out correctly
        }
        catch (Exception e)
        {
            String exceptionMessage = e.getMessage();
            Toast.makeText(getApplicationContext(), exceptionMessage, Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private void NotifyAndroid(){
        Toast.makeText(this, "Preparing notification...", Toast.LENGTH_SHORT).show();
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            NotificationChannel channel =
                    new NotificationChannel(
                            "default",
                            "NAME_FLAG",
                            NotificationManager.IMPORTANCE_DEFAULT);

            channel.setDescription("DESCRIPTION_FLAG");

            assert mNotificationManager != null;
            mNotificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "default");

        //Lets Open Whatsapp!
        Intent whatsappIntent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
        PendingIntent whatsappPendingIntent = PendingIntent.getActivity(this, 0, whatsappIntent, 0);

        mBuilder.setContentIntent(whatsappPendingIntent);
        mBuilder.setSmallIcon(R.drawable.ic_launcher_background);
        mBuilder.setContentTitle("You should probably check Whatsapp");
        mBuilder.setContentText("See chat");

        assert mNotificationManager != null;
        mNotificationManager.notify(1, mBuilder.build());
    }

    private void GoToPDFActivity() {
        Intent pdfIntent = new Intent(getApplicationContext(), PDFActivity.class);
        startActivity(pdfIntent);
    }

    private void GoToTwoFragmentsActivity() {
        Intent twoFragmentIntent = new Intent(getApplicationContext(), TwoFragmentCounterActivity.class);
        startActivity(twoFragmentIntent);
    }
}