package com.example.caballep.testingexample;

import android.util.Log;

public class Addition {

    public static final String TAG = "Addition";
    public int add(int n1, int n2) {
        Log.d(TAG, "add: " + n1 + " " + n2);
        return n1 + n2;
    }

    public void doNothing(){

    }
}
