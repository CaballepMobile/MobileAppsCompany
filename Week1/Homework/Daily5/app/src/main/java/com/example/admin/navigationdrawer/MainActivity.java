package com.example.admin.navigationdrawer;

import android.content.ClipData;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar tbMain;
    private ActionBar actionbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BindViews();
        InitializeMenu();
        InitializeToolBar();
    }

    //Binding widgets and layouts
    private void BindViews() {
        drawerLayout = findViewById(R.id.dlMain);
        navigationView = findViewById(R.id.nvMain);
        tbMain = findViewById(R.id.tbMain);
    }

    //Close the application
    private void CloseApplication(){
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }

    //Move to YoutubeActivity
    private void GoToYoutubeViewerActivity(){
        Intent youtubeIntent = new Intent(this, YoutubeViewerActivity.class);
        startActivity(youtubeIntent);
    }

    //Move to MyLocationActivity
    private void GoToMyLocationActivity(){
        Intent myLocationIntent = new Intent(this, MyLocationActivity.class);
        startActivity(myLocationIntent);
    }

    //NavigationDrawerMenuButton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Make all the options on the navigation drawer work
    private void InitializeMenu(){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();

                int itemId = menuItem.getItemId();

                switch (itemId) {
                    case R.id.itMyLocation:
                        GoToMyLocationActivity();
                        break;


                    case R.id.itYoutube:
                        GoToYoutubeViewerActivity();
                        break;

                    case R.id.itCloseApp:

                        CloseApplication();
                        break;
                }

                return true;
            }
        });
    }

    private void InitializeToolBar(){
        setSupportActionBar(tbMain);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}