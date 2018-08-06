package com.example.admin.daily5.Activities;

import android.content.Context;
import android.content.Intent;

public class ActivityHandler {
    public static void OpenDataPersistenceActivity(Context context){
        Intent intent = new Intent(context, ActivityDictionary.Activities.DATA_PERSISTANCE_ACTIVITY);
        //I was trying to open the activity from here but i realize that the StartActivity method belongs to Activity class itself
    }
}
