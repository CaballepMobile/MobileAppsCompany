package com.example.admin.handlingfragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAddRed, btnAddBlue, btnRemoveRed, btnRemoveBlue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void removeFragments(View view){
        switch(view.getId()){

        }
    }

    public void evtAddFragment(View view) {
        int viewId = view.getId();
        switch(viewId){
            case R.id.btnAddRed:
                Fragment redFragment = new Fragment();

                break;
        }
    }

    public void evtRemoveFragment(View view) {
        int viewId = view.getId();
        switch(viewId){
            case R.id.btnRemoveRed:

                break;
        }
    }
}
