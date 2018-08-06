package com.example.admin.daily5;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

import com.example.admin.daily5.Activities.ActivityDictionary;
import com.example.admin.daily5.Tools.MyChronometer;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private MyChronometer myChronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myChronometer = new MyChronometer();
        myChronometer.start();

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();
                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        int itemId = menuItem.getItemId();
                        switch (itemId) {
                            case (R.id.itDataPersistence):
                                OpenDataPersistenceActivity();
                                break;

                            case (R.id.itMyLocation):
                                OpenMyLocation();
                                break;

                            case (R.id.itClose):
                                CloseApp();
                                break;
                        }

                        return true;
                    }
                });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setDisplayShowHomeEnabled(true);
        actionbar.setDisplayShowTitleEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_view_list_black_24dp);

        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {
                //Toast.makeText(MainActivity.this, "Drawer is Sliding", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerOpened(@NonNull View view) {
                Toast.makeText(MainActivity.this, "Drawer is Open", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(@NonNull View view) {
                Toast.makeText(MainActivity.this, "Drawer is Closed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerStateChanged(int i) {
                //Toast.makeText(MainActivity.this, "Drawer State have Change", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;

            case R.id.itPlaySound:
                PlaySound();
                break;

            case R.id.itLike:
                Like(item);
                break;

            case R.id.itShare:
                Share();
                break;

            case R.id.itTimeSpent:
                TimeSpent();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tool_bar_menu, menu);
        return true;
    }

    private void OpenDataPersistenceActivity() {
        Intent intent = new Intent(getApplicationContext(), ActivityDictionary.Activities.DATA_PERSISTANCE_ACTIVITY);
        startActivity(intent);
    }

    private void PlaySound() {
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.wubalubadubdub);
        mediaPlayer.start();
    }

    private boolean like = false;

    private void Like(MenuItem item) {
        if (!like) {
            Toast.makeText(this, "I am glad you like this app!", Toast.LENGTH_SHORT).show();
            item.setIcon(R.drawable.ic_thumb_down_black_24dp);
            like = true;
        } else {
            Toast.makeText(this, "Too bad you dont like this app...", Toast.LENGTH_SHORT).show();
            item.setIcon(R.drawable.ic_thumb_up_black_24dp);
            like = false;
        }
    }

    private void OpenMyLocation(){
        Intent mapsIntent = new Intent(getApplicationContext(), ActivityDictionary.Activities.MAPS_ACTIVITY);
        startActivity(mapsIntent);
    }

    private void Share() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello from the best application ever!");
        startActivity(Intent.createChooser(shareIntent, "Share this link through a MAC App"));
    }

    private void TimeSpent(){
        Toast.makeText(this, myChronometer.TimeSpent(), Toast.LENGTH_SHORT).show();
    }

    private void CloseApp(){
        finish();
    }
}